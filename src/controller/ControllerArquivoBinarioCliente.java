
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author Cris
 */
public class ControllerArquivoBinarioCliente extends ControllerArquivoBinario {
    
    private static final List<Cliente> clientes = new ArrayList<Cliente>();
    protected Cliente cliente = new Cliente();

    public void lerClientes(){
        setArquivo("Abrir");
        ler();
        
        List<Object> obj = getObjects();
        clientes.removeAll(clientes);
        for(Object o: obj){
            clientes.add((Cliente) o);
        }
    }
    
    public int countId(){
        int count = 0;
        if(clientes != null){
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
        if(getArquivo() == null){
            setArquivo("Salvar");
        }
        cliente.setId(countId());
        setObject(cliente);
        write(true);
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
        setObject(null);
        escrever(false);
        for(Cliente in: clientes){
            setObject(in);
            escrever(true);
        }
    }
    
    public void removeCliente(int id){ 
        Cliente i = buscarCliente(id);
        clientes.remove(i);
        setObject(null);
        escrever(false);
        for(Cliente in: clientes){
            setObject(in);
            escrever(true);
        }
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return (Cliente) getObjeto();
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.setObject(cliente);
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
