

package br.com.prestadoradeservicos.dao;
        

import br.com.prestadoradeservicos.conexoes.FabricaDeConexoes;
import br.com.prestadoradeservicos.entidades.TipoDeServico;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class TipoDeServicoDao {
    
    private Connection con;
    
    public TipoDeServicoDao(){
        this.con = FabricaDeConexoes.getConexao();
    }
   
    public void salvar(TipoDeServico objeto){
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into tipodeservico (descricao) values (?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1,objeto.getDescricao());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null,"Tipo de Serviço - " + objeto + " - foi cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(TipoDeServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List listar(){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List <TipoDeServico> list = null;
        try {

            conn = this.con;

            String sql = "select * from tipodeservico ORDER BY descricao";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<TipoDeServico>();
            while(rs.next()){
                TipoDeServico objeto = new TipoDeServico();
                objeto.setId(rs.getInt(1));
                objeto.setDescricao(rs.getString(2));
                list.add(objeto);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TipoDeServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            FabricaDeConexoes.fecharConexao(conn, ps);
        }
        return list;
    }
    
    
    
    public TipoDeServico listarPorId(Integer id){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        TipoDeServico objeto = null;
        try {
            
            conn = this.con;          
            
            String sql = "select * from tipodeservico where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
           
            while(rs.next()){
                objeto = new TipoDeServico();
                objeto.setId(rs.getInt(1));
                objeto.setDescricao(rs.getString(2));
            }
            return objeto;
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDeServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            FabricaDeConexoes.fecharConexao(conn, ps);
        }
        return objeto;
    }
    
    public void atualizar(TipoDeServico objeto){
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "update tipodeservico set descricao = ? where id = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1,objeto.getDescricao());
            ps.setInt(2, objeto.getId());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null,"Tipo de Serviço - " + objeto + " - foi atualizado com sucesso. ");
        } catch (SQLException ex) {
            Logger.getLogger(TipoDeServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void excluir(TipoDeServico objeto){
        try {
            Connection conn;
            PreparedStatement ps;

            String sql = "delete from tipodeservico where id = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, objeto.getId());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Tipo de Serviço - " + objeto + "" +
                    " - foi excluido com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(TipoDeServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
   
    

}
