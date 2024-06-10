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
public class Compra implements Serializable {
    private static long serialVersionUID = 1L;
    protected int id;
    protected String produto;
    protected double preco;
    protected String cliente;

    
    public Compra(){
    }
    
    public Compra(int id, String nm, double prec, String cli) {
        this.id = id;
        this.produto = nm;
        this.preco = prec;
        this.cliente = cli;
    }

    @Override
    public String toString() {
        String resposta = this.getId() + "\n";
        resposta += this.getProduto() + "\n";
        resposta += this.getPreco() + "\n";
        resposta += this.getCliente() + "\n\n\n";
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
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the nome to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the idade to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the email
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the email to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
