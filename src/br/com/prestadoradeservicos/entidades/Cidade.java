/*
 * Cidade.java
 *
 * Created on 6 de Novembro de 2008, 19:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.prestadoradeservicos.entidades;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class Cidade {
    
    /**
     * Creates a new instance of Cidade
     */
    public Cidade() {
    }

    private Integer id;

    private String estado;

    private String cidade;


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object obj) {
         if( obj instanceof Cidade ) {
             Cidade o = ( Cidade ) obj;
             if( o.getId() == this.getId() ){
                 return true;
             } else {
                 return false;}
         } else{
             return false;}
     }

    @Override
    public String toString() {
        return getEstado()+" - "+getCidade();
    }
    
}
