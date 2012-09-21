/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.prestadoradeservicos.controlers;

import br.com.prestadoradeservicos.dao.CidadeDao;
import br.com.prestadoradeservicos.dao.ClienteDao;
import br.com.prestadoradeservicos.entidades.Cidade;
import br.com.prestadoradeservicos.entidades.Cliente;
import br.com.prestadoradeservicos.views.CadastroDeClienteView;
import java.util.List;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class CadastroDeClienteControler {

    private static CadastroDeClienteControler instancia = new CadastroDeClienteControler();
    private CadastroDeClienteView view;
    private Cliente model = new Cliente();    
    
    public CadastroDeClienteControler() {
        
    }
    
    /**
     * @return a instancia do controlador
     */
    public static CadastroDeClienteControler getInstancia() {
        return instancia;
    }
   

    /**
     * Exibe a interface gráfica do controlador
     */
    public void exibirInterfaceGrafica(){

        if(view == null){
            view = new CadastroDeClienteView(this);
        }

        view.setVisible(true);

    }
   
    /**    
     * @return a lista de cidades cadastradas
     */
    public List<Cidade> listarCidades(){

        List<Cidade> lista = new CidadeDao().listar();
        return lista;

    }

    /**
     * Salva o cliente no banco de dados
     */
    public void salvarCliente(){

        view.sincronizarModelComView(model);
        if(model.getId() == null){
            new ClienteDao().salvar(model);
        }else{
            new ClienteDao().atualizar(model);
        }


    }

    /**    
     * @return a lista de clientes cadastrados
     */
    public List<Cliente> listarClientes(){

        List<Cliente> lista = new ClienteDao().listar();
        return lista;

    }

    /**
     * Exclui o cliente no banco de dados
     */
    public void excluirCliente(){

        view.sincronizarModelComView(model);
        if(model.getId() != null){
            new ClienteDao().excluir(model);
        }

    }

}
