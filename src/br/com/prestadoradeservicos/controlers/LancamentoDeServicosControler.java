/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prestadoradeservicos.controlers;

import br.com.prestadoradeservicos.views.LancamentoDeServicosView;
import br.com.prestadoradeservicos.entidades.Servico;
import br.com.prestadoradeservicos.entidades.TipoDeServico;
import br.com.prestadoradeservicos.dao.ServicoDao;
import br.com.prestadoradeservicos.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class LancamentoDeServicosControler {

    private static LancamentoDeServicosControler instancia = new LancamentoDeServicosControler();
    private LancamentoDeServicosView view;
    private Servico model = new Servico();

    public LancamentoDeServicosControler() {
    }

    /**
     * @return the instancia
     */
    public static LancamentoDeServicosControler getInstancia() {
        return instancia;
    }

    public void exibirInterfaceGrafica() {

        if (view == null) {
            view = new LancamentoDeServicosView(this);
        }

        view.setVisible(true);

    }

    public List<TipoDeServico> listaTiposDeServico() {

        return CadastroDeTiposDeServicoControler.getInstancia().listarTiposDeServico();

    }

    public List<Cliente> listaClientes() {

        return CadastroDeClienteControler.getInstancia().listarClientes();

    }

    public void salvarServico() {

        if (view.sincronizarModelComView(model)) {

            if (model.getId() == null) {
                new ServicoDao().salvar(model);
            } else {
                new ServicoDao().atualizar(model);
            }

        }

    }

    public List<Servico> listarServicos(){

        return new ServicoDao().listar();

    }

    public Integer verificarTotalDeServicosLancadosNoDia(java.util.Date data){

        return new ServicoDao().contarTotalDeServicosLancadosNoDia(data);
        
    }


    public void excluirServico(){

        view.sincronizarModelComView(model);
        if(model.getId() != null){
            new ServicoDao().excluir(model);
        }

    }

}
