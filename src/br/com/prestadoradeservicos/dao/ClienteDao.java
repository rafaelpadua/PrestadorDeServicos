

package br.com.prestadoradeservicos.dao;
        

import br.com.prestadoradeservicos.conexoes.FabricaDeConexoes;
import br.com.prestadoradeservicos.entidades.Cliente;
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
public class ClienteDao {
    
    private Connection con;
    private CidadeDao cidadeDao = new CidadeDao();
    
    public ClienteDao(){
        this.con = FabricaDeConexoes.getConexao();
    }
   
    public void salvar(Cliente cliente){
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into cliente (nome,razaoSocial,cnpj,telefone,contato,telefoneContato,celularContato,emailContato,cidade_id,endereco) values (?,?,?,?,?,?,?,?,?,?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getRazaoSocial());
            ps.setString(3, cliente.getCnpj());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getContato());
            ps.setString(6, cliente.getTelefoneDoContato());
            ps.setString(7, cliente.getCelularDoContato());
            ps.setString(8, cliente.getEmailDoContato());
            ps.setInt(9, cliente.getCidade().getId());
            ps.setString(10, cliente.getEndereco());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null,"Cliente - " + cliente + " - foi cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List listar(){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List <Cliente> list = null;
        try {

            conn = this.con;

            String sql = "select * from cliente ORDER BY nome";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<Cliente>();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setRazaoSocial(rs.getString(3));
                cliente.setCnpj(rs.getString(4));
                cliente.setTelefone(rs.getString(5));
                cliente.setContato(rs.getString(6));
                cliente.setTelefoneDoContato(rs.getString(7));
                cliente.setCelularDoContato(rs.getString(8));
                cliente.setEmailDoContato(rs.getString(9));                
                cliente.setCidade(new CidadeDao().listarPorId(rs.getInt(10)));
                cliente.setEndereco(rs.getString(11));
                list.add(cliente);                
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            FabricaDeConexoes.fecharConexao(conn, ps);
        }
        return list;
    }
    
    
    
    public Cliente listarPorId(Integer id){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {

            conn = this.con;

            String sql = "select * from cliente where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();           
            while(rs.next()){
                cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setRazaoSocial(rs.getString(3));
                cliente.setCnpj(rs.getString(4));
                cliente.setTelefone(rs.getString(5));
                cliente.setContato(rs.getString(6));
                cliente.setTelefoneDoContato(rs.getString(7));
                cliente.setCelularDoContato(rs.getString(8));
                cliente.setEmailDoContato(rs.getString(9));
                cliente.setCidade(cidadeDao.listarPorId(rs.getInt(10)));
                cliente.setEndereco(rs.getString(11));
            }
            return cliente;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            FabricaDeConexoes.fecharConexao(conn, ps);
        }
        return cliente;
    }
    
    public void atualizar(Cliente cliente){
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "update cliente set nome = ?, razaoSocial = ?, cnpj = ?, telefone = ?, contato = ?, telefoneContato = ?, celularContato = ?, emailContato = ?, cidade_id = ?, endereco = ? where id = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getRazaoSocial());
            ps.setString(3, cliente.getCnpj());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getContato());
            ps.setString(6, cliente.getTelefoneDoContato());
            ps.setString(7, cliente.getCelularDoContato());
            ps.setString(8, cliente.getEmailDoContato());
            ps.setInt(9, cliente.getCidade().getId());
            ps.setString(10, cliente.getEndereco());
            ps.setInt(11, cliente.getId());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null,"Cliente - " + cliente + " - foi atualizado com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void excluir(Cliente cliente){
        try {
            Connection conn;
            PreparedStatement ps;

            String sql = "delete from cliente where id = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Cliente - " + cliente + "" +
                    " - foi excluido com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    

}
