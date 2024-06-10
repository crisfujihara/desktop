
package controller;

import java.io.Serializable;

/**
 *
 * @author Cris
 */
public class Properties implements Serializable {

    private static final long serialVersionUID = 1;

    private String pastadefault = System.getProperty("user.dir");
    private String arqcliente = "clientes.bin";
    private String arqcompra = "compras.bin";
    private String arqinstrumento = "instrumentos.bin";

    /**
     * @return the pastadefault
     */
    public String getPastadefault() {
        return pastadefault;
    }

    /**
     * @param pastadefault the pastadefault to set
     */
    public void setPastadefault(String pastadefault) {
        this.pastadefault = pastadefault;
    }

    /**
     * @return the arqcliente
     */
    public String getArqcliente() {
        return arqcliente;
    }

    /**
     * @param arqcliente the arqcliente to set
     */
    public void setArqcliente(String arqcliente) {
        this.arqcliente = arqcliente;
    }

    /**
     * @return the arqfornecedor
     */
    public String getArqcompra() {
        return arqcompra;
    }

    /**
     * @param arqcompra the arqfornecedor to set
     */
    public void setArqfornecedor(String arqcompra) {
        this.arqcompra = arqcompra;
    }

    /**
     * @return the arqproduto
     */
    public String getArqinstrumento() {
        return arqinstrumento;
    }

    /**
     * @param arqinstrumento the arqproduto to set
     */
    public void setArqinstrumento(String arqinstrumento) {
        this.arqinstrumento = arqinstrumento;
    }
    

    public static void main(String[] args) {
        Properties prop = new Properties();

        ControllerArquivoBinario controller
                = new ControllerArquivoBinario();
        
        controller.setArquivo("salvar");
        controller.setObject(prop);
        controller.escrever(false);
    }
}
