/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.prestadoradeservicos.controlers;

import br.com.prestadoradeservicos.uteis.GeradorDeRelatorio;
import br.com.prestadoradeservicos.views.ProgressBar;
import br.com.prestadoradeservicos.views.RelatorioServicosExecutadosView;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class RelatorioServicosExecutadosControler {

    private static RelatorioServicosExecutadosControler instancia = new RelatorioServicosExecutadosControler();
    private RelatorioServicosExecutadosView view;
    private ProgressBar progressBar;
    
    public RelatorioServicosExecutadosControler() {
        
    }
    
    /**
     * @return the instancia
     */
    public static RelatorioServicosExecutadosControler getInstancia() {
        return instancia;
    }
   

    public void exibirInterfaceGrafica(){

        if(view == null){
            view = new RelatorioServicosExecutadosView(this);
        }

        view.setVisible(true);

    }
   
   
    public void gerarRelatorio(Date dataInicial, Date dataFinal){

        GeradorDeRelatorio gerador = new GeradorDeRelatorio();
        gerador.setNomeDoRelatorio("RelatorioDeServicosExecutados");
        Map parametros = new HashMap();
        parametros.put("dataInicial", dataInicial);
        parametros.put("dataFinal", dataFinal);
        gerador.setParameters(parametros);
        try {
            gerador.gerarRelatorio();
        } catch (Exception ex) {
           ex.printStackTrace();
        }

    }

    public void carregarRelatorio(Date dataInicial, Date dataFinal){

        if(progressBar == null){
            progressBar = new ProgressBar(this);
        }
        progressBar.setVisible(true);
        progressBar.carregarRelatorioServicosExecutados(dataInicial, dataFinal);

    }
    
    

    
    

}
