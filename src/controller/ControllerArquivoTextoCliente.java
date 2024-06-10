package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import model.Cliente;

/**
 *
 * @author Cris
 */
public class ControllerArquivoTextoCliente extends ControllerArquivoTexto {
    
    private static final List<Cliente> clientes = new ArrayList<Cliente>();
    protected Cliente cliente = new Cliente();

    public void lerClientes() {
        setArquivo("Abrir");
        ler();
        String aux = getTexto();
        
        StringTokenizer tokens = new StringTokenizer(aux, ";");
        clientes.removeAll(clientes);
        for(int t = tokens.countTokens()/4; t > 0; t--){
            Cliente i = new Cliente();
            i.setId(Integer.valueOf(tokens.nextToken()));
            i.setNome(tokens.nextToken());
            i.setIdade(Integer.valueOf(tokens.nextToken()));
            i.setEmail(tokens.nextToken());
            clientes.add(i);
        }
    }
    
    public int countId(){
        int count = 0;
        if(clientes !=null){
           count = clientes.size();
        }
        return count;
    }
    
    
    public Cliente buscarCliente(int id) {        
        for(Cliente i: clientes){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }

    public void gravarCliente() {
        int id = countId();
        String aux = id + ";" + cliente.getNome() + ";" + cliente.getIdade()+ ";" + cliente.getEmail() + ";";
        setTexto(aux);
        if(getArquivo() == null){
            setArquivo("Salvar");
        }
        escrever(true);
        clientes.add(cliente);
    }
    
    public void editarCliente(int id) {
        Cliente i = buscarCliente(id);
        if(!"".equals(cliente.getNome())){
            i.setNome(cliente.getNome());
        }
        if(cliente.getIdade() != 0){
            i.setIdade(cliente.getIdade());
        }
        if(!"".equals(cliente.getEmail())){
            i.setEmail(cliente.getEmail());
        }
        clear();
        for(Cliente in: clientes){
            String aux = in.getId() + ";" + in.getNome() + ";" + in.getIdade()+ ";" + in.getEmail() + ";";
            setTexto(aux);
            escrever(true);
        }
    }
    
    public void removeCliente(int id){ 
        Cliente i = buscarCliente(id);
        clientes.remove(i);
        clear();
        for(Cliente in: clientes){
            String aux = in.getId() + ";" + in.getNome() + ";" + in.getIdade()+ ";" + in.getEmail() + ";";
            setTexto(aux);
            escrever(true);
        }
    }

    /**
     * @return the instrumento
     */
    public Cliente getCliente() {
        return cliente;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

/**
     * @param nome
     * @param idade
     * @param email
     */
    public void setCliente(String nome, int idade, String email) {
        this.cliente.setNome(nome);
        this.cliente.setIdade(idade);
        this.cliente.setEmail(email);
    }    
    
}
