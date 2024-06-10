/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;

/**
 *
 * @author Cris
 */
public class Cliente implements Serializable {
    private static long serialVersionUID = 1L;
    protected int id;
    protected String nome;
    protected int idade;
    protected String email;

    
    public Cliente(){
    }
    
    public Cliente(int id, String nm, int idade, String email) {
        this.id = id;
        this.nome = nm;
        this.idade = idade;
        this.email = email;
    }

    @Override
    public String toString() {
        String resposta = this.getId() + "\n";
        resposta += this.getNome() + "\n";
        resposta += this.getIdade() + "\n";
        resposta += this.getEmail() + "\n\n\n";
        return resposta;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
