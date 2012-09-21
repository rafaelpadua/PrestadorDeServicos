/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.prestadoradeservicos.controlers;

import br.com.prestadoradeservicos.conexoes.FabricaDeConexoes;
import br.com.prestadoradeservicos.views.ProgressBar;
import br.com.prestadoradeservicos.views.TelaPrincipal;
import java.sql.Connection;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class TelaPrincipalControler {

    private static TelaPrincipalControler instancia = new TelaPrincipalControler();
    private TelaPrincipal view;
    private ProgressBar progressBar;
    
    public TelaPrincipalControler() {
        
    }
    
    /**
     * @return the instancia
     */
    public static TelaPrincipalControler getInstancia() {
        return instancia;
    }
   

    public void exibirInterfaceGrafica(){

        if(view == null){            
            view = new TelaPrincipal(this);
        }

        view.setVisible(true);

    }

    public void carregarInterfaceGrafica(){

        if(progressBar == null){
            progressBar = new ProgressBar(this);
        }

        progressBar.setVisible(true);
        progressBar.carregarInterfaceGraficaTelaPrincipal();


    }


    public void exibirClienteView(){

        CadastroDeClienteControler.getInstancia().exibirInterfaceGrafica();

    }

    public void exibirCadastroDeTipoDeServicosView(){

        CadastroDeTiposDeServicoControler.getInstancia().exibirInterfaceGrafica();

    }

    public void exibirLancamentoDeServicosView(){

        LancamentoDeServicosControler.getInstancia().exibirInterfaceGrafica();

    }

    public void exibirRelatorioDeServicosExecutados(){

       RelatorioServicosExecutadosControler.getInstancia().exibirInterfaceGrafica();

    }

    public void iniciarSessionFactory(){
        Connection conn = FabricaDeConexoes.getConexao();
    }
    
    

    
    

}
