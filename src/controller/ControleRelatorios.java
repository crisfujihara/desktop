/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cris
 */
public class ControleRelatorios {

    Connection connection = null;

    public static final String pasta_relatorios = System.getProperty("user.dir") + "/relatorios/";

    public static final File file_relatorio_cliente_fonte = new File(pasta_relatorios, "relatorio_clientes.jrxml");
    public static final File file_relatorio_cliente_compilado = new File(pasta_relatorios, "relatorio_clientes.jasper");
    public static final File relatorio_cliente_pdf = new File(pasta_relatorios, "relatorio_clientes.pdf");

    public static final File file_relatorio_cliente_parametro_fonte = new File(pasta_relatorios, "relatorio_parametro.jrxml");
    public static final File file_relatorio_cliente_parametro_compilado = new File(pasta_relatorios, "relatorio_parametro.jasper");
    public static final File relatorio_cliente_parametro_pdf = new File(pasta_relatorios, "relatorio_parametro.pdf");

    public static final File file_relatorio_produto_fonte = new File(pasta_relatorios, "produto.jrxml");
    public static final File file_relatorio_produto_compilado = new File(pasta_relatorios, "produto.jasper");

    public static final File file_relatorio_vendas_fonte = new File(pasta_relatorios, "vendas.jrxml");
    public static final File file_relatorio_vendas_compilado = new File(pasta_relatorios, "vendas.jasper");

    public ControleRelatorios() {
        try {
            String path = System.getProperty("user.dir");
            File config_file = new File(path, "configuracaobd.properties");
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
        } catch (ClassNotFoundException | SQLException | IOException erro) {
            System.out.println("Erro ao criar conexao com o BD.");
        }
        //System.out.println(System.getProperties());    
    }

    public void RelatorioCliente(boolean view) {
        JasperPrint impressao;
        try {
            // caso seja necessário, compila o relatório (caso deseja usar o jrxml)
            FileInputStream arquivo = new FileInputStream(file_relatorio_cliente_fonte);//jrxml
            JasperReport relatorio = JasperCompileManager.compileReport(arquivo);

            //ou poderia utilizar diretamente o relatorio compilado
            //FileInputStream relatorio = new FileInputStream(file_relatorio_cliente_compilado);//jasper
            //preenchimento do relatorio com a conexao e parametros
            impressao = JasperFillManager.fillReport(
                    relatorio,//arquivo jasper
                    null,//parametros
                    connection);//conexao
            if (view) {
                //opcao de visualizar o relatorio
                JasperViewer.viewReport(impressao, false);
            } else {
                //opcao de exportar o relatorio diretamente para arquivo
                JasperExportManager.exportReportToPdfFile(impressao, relatorio_cliente_pdf.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Gerado o arquivo com sucesso: " + relatorio_cliente_pdf.getAbsolutePath());
            }
        } catch (JRException | FileNotFoundException erro) {
            System.err.println("Não foi possível exportar o relatório.\n\n" + erro);
        }
    }

    public void RelatorioClienteParametro(Map parametros, boolean view) {
        JasperPrint impressao;
        try {
            //caso use o relatorio ja compilado (arquivo .jasper)
            FileInputStream relatorio = new FileInputStream(file_relatorio_cliente_parametro_compilado);//jasper

            //ou caso seja necessário, compila o relatório (caso deseja usar o jrxml)
            //FileInputStream arquivo = new FileInputStream(file_relatorio_cliente_parametro_fonte);//jrxml
            //JasperReport relatorio = JasperCompileManager.compileReport(arquivo);//compilar
            impressao = JasperFillManager.fillReport(
                    relatorio,//arquivo .jasper
                    parametros,
                    connection);
            if (view) {
                JasperViewer.viewReport(impressao, false);
            } else {
                JasperExportManager.exportReportToPdfFile(impressao, relatorio_cliente_parametro_pdf.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Gerado o arquivo " + relatorio_cliente_parametro_pdf.getAbsolutePath());
            }
        } catch (FileNotFoundException | JRException ex) {
            System.err.println("Não foi possível exportar o relatório.\n\n");
        }
    }

    public void RelatorioProdutos(Map parametros) {
        JasperPrint impressao;
        try {

            //caso use o relatorio ja compilado (arquivo .jasper)
            FileInputStream relatorio = new FileInputStream(file_relatorio_produto_compilado);//jasper

            //ou caso seja necessário, compila o relatório (caso deseja usar o jrxml)
            //FileInputStream arquivo = new FileInputStream(file_relatorio_produto_fonte);//jrxml
            //JasperReport relatorio = JasperCompileManager.compileReport(arquivo);//compilar
            impressao = JasperFillManager.fillReport(
                    relatorio,//arquivo compilado ou .jasper ou o .jrxml compilado (veja acima)
                    parametros,
                    connection);

            JasperViewer.viewReport(impressao, false);
        } catch (FileNotFoundException | JRException erro) {
            System.err.println("Não foi possível visualizar o relatório.\n\n" + erro);
        }
    }

    public void RelatorioVendas() {
        JasperPrint impressao;
        try {
            //caso use o relatorio ja compilado (arquivo .jasper)
            FileInputStream relatorio = new FileInputStream(file_relatorio_vendas_compilado);//jasper

            //ou caso seja necessário, compila o relatório (caso deseja usar o jrxml)
            //FileInputStream arquivo = new FileInputStream(file_relatorio_vendas_fonte);//jrxml
            //JasperReport relatorio = JasperCompileManager.compileReport(arquivo);//compilar
            impressao = JasperFillManager.fillReport(
                    relatorio,//arquivo compilado ou .jasper ou o .jrxml compilado (veja acima)
                    null,
                    connection);

            JasperViewer.viewReport(impressao, false);
        } catch (FileNotFoundException | JRException erro) {
            System.err.println("Não foi possível visualizar o relatório.\n\n" + erro);
        }
    }
}
