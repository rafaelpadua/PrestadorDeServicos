

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
        
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost", "rafael", "120284");
        } catch (SQLException ex) {
            Logger.getLogger(FabricaDeConexoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
