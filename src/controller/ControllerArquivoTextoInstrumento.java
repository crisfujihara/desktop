package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import model.Instrumento;

/**
 *
 * @author Cris
 */
public class ControllerArquivoTextoInstrumento extends ControllerArquivoTexto {

    private static final List<Instrumento> instrumentos = new ArrayList<Instrumento>();
    protected Instrumento instrumento = new Instrumento();

    public void lerInstrumentos() {
        setArquivo("Abrir");
        ler();
        String aux = getTexto();

        StringTokenizer tokens = new StringTokenizer(aux, ";");
        instrumentos.removeAll(instrumentos);
        for(int t = tokens.countTokens()/4; t > 0; t--){
            Instrumento i = new Instrumento();
            i.setId(Integer.valueOf(tokens.nextToken()));
            i.setNome(tokens.nextToken());
            i.setPreco(Double.valueOf(tokens.nextToken()));
            i.setDescricao(tokens.nextToken());
            instrumentos.add(i);
        }
    }
    
    public int countId(){
        int count = 0;
        if(instrumentos !=null){
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
        int id = countId();
        String aux = id + ";" + instrumento.getNome() + ";" + instrumento.getPreco()+ ";" + instrumento.getDescricao() + ";";
        setTexto(aux);
        if(getArquivo() == null){
            setArquivo("Salvar");
        }
        escrever(true);
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
        clear();
        for(Instrumento in: instrumentos){
            String aux = in.getId() + ";" + in.getNome() + ";" + in.getPreco()+ ";" + in.getDescricao() + ";";
            setTexto(aux);
            escrever(true);
        }
    }
    
    
    public void removeInstrumento(int id){ 
        Instrumento i = buscarInstrumento(id);
        instrumentos.remove(i);
        clear();
        for(Instrumento in: instrumentos){
            String aux = in.getId() + ";" + in.getNome() + ";" + in.getPreco()+ ";" + in.getDescricao() + ";";
            setTexto(aux);
            escrever(true);
        }
    }

    /**
     * @return the instrumento
     */
    public Instrumento getInstrumento() {
        return instrumento;
    }
    
    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    /**
     * @param instrumento the cliente to set
     */
    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
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
