/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.prestadoradeservicos.entidades;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class TipoDeServico {

    private Integer id;
    private String descricao;


    public TipoDeServico() {

    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object obj) {
         if( obj instanceof TipoDeServico ) {
             TipoDeServico o = ( TipoDeServico ) obj;
             if( o.getId() == this.getId() ){
                 return true;
             } else {
                 return false;}
         } else{
             return false;}
    }

    @Override
    public String toString() {
        return getDescricao();
    }



    


}
