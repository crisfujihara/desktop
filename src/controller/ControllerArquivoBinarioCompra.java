
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Compra;

/**
 *
 * @author Cris
 */
public class ControllerArquivoBinarioCompra extends ControllerArquivoBinario {
    
    private static final List<Compra> compras = new ArrayList<Compra>();
    protected Compra compra = new Compra();

    public void lerCompras(){
        setArquivo("Abrir");
        ler();
        
        List<Object> obj = getObjects();
        compras.removeAll(compras);
        for(Object o: obj){
            compras.add((Compra) o);
        }
    }
    
    public int countId(){
        int count = 0;
        if(compras != null){
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
        if(getArquivo() == null){
            setArquivo("Salvar");
        }
        compra.setId(countId());
        setObject(compra);
        write(true);
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
        setObject(null);
        escrever(false);
        for(Compra in: compras){
            setObject(in);
            escrever(true);
        }
    }
    
    public void removeCompra(int id){ 
        Compra i = buscarCompra(id);
        compras.remove(i);
        setObject(null);
        escrever(false);
        for(Compra in: compras){
            setObject(in);
            escrever(true);
        }
    }
    
    public List<Compra> getCompras() {
        return compras;
    }
    
    /**
     * @return the cliente
     */
    public Compra getCompra() {
        return (Compra) getObjeto();
    }

    /**
     * @param compra the cliente to set
     */
    public void setCompra(Compra compra) {
        this.setObject(compra);
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
