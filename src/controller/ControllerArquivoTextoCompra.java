package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import model.Compra;

/**
 *
 * @author Cris
 */
public class ControllerArquivoTextoCompra extends ControllerArquivoTexto {

    private static final List<Compra> compras = new ArrayList<Compra>();
    protected Compra compra = new Compra();

    public void lerCompras() {
        setArquivo("Abrir");
        ler();
        String aux = getTexto();

        StringTokenizer tokens = new StringTokenizer(aux, ";");
        compras.removeAll(compras);
        for(int t = tokens.countTokens()/4; t > 0; t--){
            Compra i = new Compra();
            i.setId(Integer.valueOf(tokens.nextToken()));
            i.setProduto(tokens.nextToken());
            i.setPreco(Double.valueOf(tokens.nextToken()));
            i.setCliente(tokens.nextToken());
            compras.add(i);
        }
    }
    
    public int countId(){
        int count = 0;
        if(compras !=null){
           count = compras.size();
        }
        return count;
    }
    
    public Compra buscarCompra(int id) {
        for(Compra i: compras){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }

    public void gravarCompra() {
        int id = countId();
        String aux = id + ";" + compra.getProduto() + ";" + compra.getPreco()+ ";" + compra.getCliente() + ";";
        setTexto(aux);
        if(getArquivo() == null){
            setArquivo("Salvar");
        }
        escrever(true);
        compras.add(compra);
    }
    
    public void editarCompra(int id) {
        Compra i = buscarCompra(id);
        if(!"".equals(compra.getProduto())){
            i.setProduto(compra.getProduto());
        }
        if(compra.getPreco() != 0){
            i.setPreco(compra.getPreco());
        }
        if(!"".equals(compra.getCliente())){
            i.setCliente(compra.getCliente());
        }
        clear();
        for(Compra in: compras){
            String aux = in.getId() + ";" + in.getProduto() + ";" + in.getPreco()+ ";" + in.getCliente() + ";";
            setTexto(aux);
            escrever(true);
        }
    }
    
    public void removeCompra(int id){ 
        Compra i = buscarCompra(id);
        compras.remove(i);
        clear();
        for(Compra in: compras){
            String aux = in.getId() + ";" + in.getProduto() + ";" + in.getPreco()+ ";" + in.getCliente() + ";";
            setTexto(aux);
            escrever(true);
        }
    }

    /**
     * @return the instrumento
     */
    public Compra getCompra() {
        return compra;
    }
    
    public List<Compra> getCompras() {
        return compras;
    }

    /**
     * @param compra the cliente to set
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

/**
     * @param produto
     * @param preco
     * @param cliente
     */
    public void setCompra(String produto, double preco, String cliente) {
        this.compra.setProduto(produto);
        this.compra.setPreco(preco);
        this.compra.setCliente(cliente);
    }    
    
}
