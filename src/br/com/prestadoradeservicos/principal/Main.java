/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.prestadoradeservicos.principal;

import br.com.prestadoradeservicos.controlers.TelaPrincipalControler;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TelaPrincipalControler.getInstancia().carregarInterfaceGrafica();

    }

}
