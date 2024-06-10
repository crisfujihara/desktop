
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Instrumento;

/**
 *
 * @author Cris
 */
public class ControllerArquivoBinarioInstrumento extends ControllerArquivoBinario {
    
    private static final List<Instrumento> instrumentos = new ArrayList<Instrumento>();
    protected Instrumento instrumento = new Instrumento();

    public void lerInstrumentos(){
        setArquivo("Abrir");
        ler();
        
        List<Object> obj = getObjects();
        instrumentos.removeAll(instrumentos);
        for(Object o: obj){
            instrumentos.add((Instrumento) o);
        }
    }
    
    public int countId(){
        int count = 0;
        if(instrumentos != null){
           count = instrumentos.size();

        }

        return count;
    }
    
    
    public Instrumento buscarInstrumento(int id) {
        for(Instrumento i: instrumentos){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }

    public void gravarInstrumento() {
        if(getArquivo() == null){
            setArquivo("Salvar");
        }
        instrumento.setId(countId());
        setObject(instrumento);
        write(true);
        instrumentos.add(instrumento);
    }
    
    public void editarInstrumento(int id) {
        Instrumento i = buscarInstrumento(id);
        if(!"".equals(instrumento.getNome())){
            i.setNome(instrumento.getNome());
        }
        if(instrumento.getPreco() != 0){
            i.setPreco(instrumento.getPreco());
        }
        if(!"".equals(instrumento.getDescricao())){
            i.setDescricao(instrumento.getDescricao());
        }
        escrever(false);
        for(Instrumento in: instrumentos){
            setObject(in);
            escrever(true);
        }
    }
    
    public void removeInstrumento(int id){ 
        Instrumento i = buscarInstrumento(id);
        instrumentos.remove(i);
        setObject(null);
        escrever(false);
        for(Instrumento in: instrumentos){
            setObject(in);
            escrever(true);
        }
    }
    
    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }
    
    /**
     * @return the cliente
     */
    public Instrumento getInstrumento() {
        return (Instrumento) getObjeto();
    }

    /**
     * @param instrumento the cliente to set
     */
    public void setInstrumento(Instrumento instrumento) {
        this.setObject(instrumento);
    }
    
    /**
     * @param nome
     * @param preco
     * @param descricao
     */
    public void setInstrumento(String nome, double preco, String descricao) {
        this.instrumento.setNome(nome);
        this.instrumento.setPreco(preco);        
        this.instrumento.setDescricao(descricao);
    }    
}
