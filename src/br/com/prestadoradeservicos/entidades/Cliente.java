/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.prestadoradeservicos.entidades;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class Cliente {

    private Integer id;
    private String nome;
    private String razaoSocial;
    private String cnpj;
    private String telefone;
    private String contato;
    private String telefoneDoContato;
    private String celularDoContato;
    private String emailDoContato;
    private Cidade cidade;
    private String endereco;


    public Cliente() {

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @return the telefoneDoContato
     */
    public String getTelefoneDoContato() {
        return telefoneDoContato;
    }

    /**
     * @param telefoneDoContato the telefoneDoContato to set
     */
    public void setTelefoneDoContato(String telefoneDoContato) {
        this.telefoneDoContato = telefoneDoContato;
    }

    /**
     * @return the celularDoContato
     */
    public String getCelularDoContato() {
        return celularDoContato;
    }

    /**
     * @param celularDoContato the celularDoContato to set
     */
    public void setCelularDoContato(String celularDoContato) {
        this.celularDoContato = celularDoContato;
    }

    /**
     * @return the emailDoContato
     */
    public String getEmailDoContato() {
        return emailDoContato;
    }

    /**
     * @param emailDoContato the emailDoContato to set
     */
    public void setEmailDoContato(String emailDoContato) {
        this.emailDoContato = emailDoContato;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object obj) {
         if( obj instanceof Cliente ) {
             Cliente o = ( Cliente ) obj;
             if( o.getId() == this.getId() ){
                 return true;
             } else {
                 return false;}
         } else{
             return false;}
     }

    @Override
    public String toString() {
        return getNome();
    }

    

}
