/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.prestadoradeservicos.controlers;

import br.com.prestadoradeservicos.dao.TipoDeServicoDao;
import br.com.prestadoradeservicos.entidades.TipoDeServico;
import br.com.prestadoradeservicos.views.CadastroDeTiposDeServicosView;
import java.util.List;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class CadastroDeTiposDeServicoControler {

    private static CadastroDeTiposDeServicoControler instancia = new CadastroDeTiposDeServicoControler();
    private CadastroDeTiposDeServicosView view;
    private TipoDeServico model = new TipoDeServico();
    
    public CadastroDeTiposDeServicoControler() {
        
    }
    
    /**
     * @return the instancia
     */
    public static CadastroDeTiposDeServicoControler getInstancia() {
        return instancia;
    }
   

    public void exibirInterfaceGrafica(){

        if(view == null){
            view = new CadastroDeTiposDeServicosView(this);
        }

        view.setVisible(true);

    }

     /**
     * @return a lista de tipos de serviço cadastrados
     */
    public List<TipoDeServico> listarTiposDeServico(){

        List<TipoDeServico> lista = new TipoDeServicoDao().listar();
        return lista;

    }

     /**
     * Salva o tipo de serviço no banco de dados
     */
    public void salvarTipoDeServico(){

        view.sincronizarModelComView(model);
        if(model.getId() == null){
            new TipoDeServicoDao().salvar(model);
        }else{
            new TipoDeServicoDao().atualizar(model);
        }

    }

    /**
     * Exclui o tipo de serviço no banco de dados
     */
    public void excluirTipoDeServico(){

        view.sincronizarModelComView(model);
        if(model.getId() != null){
            new TipoDeServicoDao().excluir(model);
        }

    }
    

    

    
    

}
