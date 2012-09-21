

package br.com.prestadoradeservicos.conexoes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Anderson Luis Ribeiro
 */
public class FabricaDeConexoes {
    
    /**
     * @return a conexão com o banco de dados
     */
    public static Connection getConexao(){
        Connection con = null;
        try {
            //jdbc:mysql://localhost/prestadordeservicos", "root", "root"
            con = DriverManager.getConnection("jdbc:mysql://localhost/prestadordeservicos", "root", "root");
            System.out.println("Conxão criada com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(FabricaDeConexoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }

    /**
     * Fecha a conexão com o banco de dados
     */
    public static void fecharConexao(Connection con, Statement stm){
        try {
            con.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(FabricaDeConexoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
