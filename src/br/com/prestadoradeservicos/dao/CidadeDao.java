

package br.com.prestadoradeservicos.dao;
        

import br.com.prestadoradeservicos.entidades.Cidade;
import br.com.prestadoradeservicos.conexoes.FabricaDeConexoes;
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
public class CidadeDao {
    
    private Connection con;
    
    public CidadeDao(){
        this.con = FabricaDeConexoes.getConexao();
    }
   
    public void salvar(Cidade cidade){
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into cidade (estado,cidade) values (?,?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1,cidade.getEstado());
            ps.setString(2, cidade.getCidade());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null,"Cidade - " + cidade.getCidade() + " - foi cadastrada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List listar(){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List <Cidade> list = null;
        try {

            conn = this.con;

            String sql = "select * from cidade";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<Cidade>();
            while(rs.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt(1));
                cidade.setEstado(rs.getString(2));
                cidade.setCidade(rs.getString(3));
                list.add(cidade);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            FabricaDeConexoes.fecharConexao(conn, ps);
        }
        return list;
    }
    
    
    
    public Cidade listarPorId(Integer id){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Cidade cidade = null;
        try {
            
            conn = this.con;          
            
            String sql = "select * from cidade where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
           
            while(rs.next()){
                cidade = new Cidade();
                cidade.setId(rs.getInt(1));
                cidade.setEstado(rs.getString(2));
                cidade.setCidade(rs.getString(3));                
            }
            return cidade;
            
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            FabricaDeConexoes.fecharConexao(conn, ps);
        }
        return cidade;
    }
    
    public void atualizar(Cidade cidade){
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "update cidade set estado = ?,cidade = ? where id = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1,cidade.getEstado());
            ps.setString(2, cidade.getCidade());
            ps.setInt(3, cidade.getId());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null,"Cidade - " + cidade.getCidade() + " - foi atualizada com sucesso  " + cidade.getId());
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void excluir(Cidade cidade){
        try {
            Connection conn;
            PreparedStatement ps;

            String sql = "delete from cidade where id = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cidade.getId());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Cidade - " + cidade.getCidade() + "" +
                    " - foi excluida com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
   
    

}
