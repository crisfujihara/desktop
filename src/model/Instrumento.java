package model;
import java.io.Serializable;

/**
 *
 * @author Cris
 */
public class Instrumento implements Serializable {
    private static long serialVersionUID = 1L;
    protected double preco;
    protected int id= 0;
    protected String nome, descricao;

    public Instrumento() {
        this.preco = 0;
        this.nome = "";
        this.descricao = "";
    }
    
    public Instrumento(int id, String nm, double prec, String desc) {
        this.id = id;
        this.nome = nm;
        this.preco = prec;
        this.descricao = desc;
    }

    @Override
    public String toString() {
        String resposta = this.getId() + "\n";
        resposta += this.getNome() + "\n";
        resposta += this.getPreco() + "\n";
        resposta += this.getDescricao() + "\n\n\n";
        return resposta;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id = id;
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
