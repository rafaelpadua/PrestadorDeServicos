package br.com.prestadoradeservicos.dao;

import br.com.prestadoradeservicos.entidades.Servico;
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
public class ServicoDao {

    private Connection con;

    public ServicoDao() {
        this.con = FabricaDeConexoes.getConexao();
    }

    public void salvar(Servico servico) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into servico (cliente_id, tipoDeServico_id, dataDoServico, valorDoServico, numeroDoServico) values (?,?,?,?,?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, servico.getCliente().getId());
            ps.setInt(2, servico.getTipoDeServico().getId());
            ps.setDate(3, new java.sql.Date(servico.getDataDoServico().getTime()));
            ps.setDouble(4, servico.getValorDoServico());
            ps.setInt(5, servico.getNumeroDoServico());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Servico - " + servico + " - foi cadastrada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List listar() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Servico> list = null;
        try {

            conn = this.con;

            String sql = "select * from servico ORDER BY dataDoServico";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<Servico>();
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setId(rs.getInt(1));
                servico.setTipoDeServico(new TipoDeServicoDao().listarPorId(rs.getInt(2)));
                servico.setCliente(new ClienteDao().listarPorId(rs.getInt(3)));
                servico.setDataDoServico(new java.util.Date(rs.getDate(4).getTime()));
                servico.setValorDoServico(rs.getDouble(5));
                servico.setNumeroDoServico(rs.getInt(6));
                list.add(servico);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaDeConexoes.fecharConexao(conn, ps);
        }
        return list;
    }

    public Servico listarPorId(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Servico servico = null;
        try {

            conn = this.con;

            String sql = "select * from servico where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                servico = new Servico();
                servico.setId(rs.getInt(1));
                servico.setTipoDeServico(new TipoDeServicoDao().listarPorId(rs.getInt(2)));
                servico.setCliente(new ClienteDao().listarPorId(rs.getInt(3)));
                servico.setDataDoServico(new java.util.Date(rs.getDate(4).getTime()));
                servico.setValorDoServico(rs.getDouble(5));
                servico.setNumeroDoServico(rs.getInt(6));
            }
            return servico;

        } catch (SQLException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaDeConexoes.fecharConexao(conn, ps);
        }
        return servico;
    }

    public void atualizar(Servico servico) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "update servico set cliente_id = ?,tipoDeServico_id = ?, dataDoServico = ?, valorDoServico = ?, numeroDoServico = ? where id = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, servico.getCliente().getId());
            ps.setInt(2, servico.getTipoDeServico().getId());
            ps.setDate(3, new java.sql.Date(servico.getDataDoServico().getTime()));
            ps.setDouble(4, servico.getValorDoServico());
            ps.setInt(5, servico.getNumeroDoServico());
            ps.setInt(6, servico.getId());       
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Servico - " + servico + " - foi atualizado com sucesso. ");
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluir(Servico servico) {
        try {
            Connection conn;
            PreparedStatement ps;

            String sql = "delete from servico where id = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, servico.getId());
            ps.executeUpdate();
            FabricaDeConexoes.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Serviço - " + servico + "" +
                    " - foi excluido com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public Integer contarTotalDeServicosLancadosNoDia(java.util.Date data) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Integer total = null;
        try {

            conn = this.con;

            String sql = "select count(id) as total from servico where dataDoServico = ?";
            ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(data.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {               
                total = rs.getInt(1);
            }
            return total;

        } catch (SQLException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaDeConexoes.fecharConexao(conn, ps);
        }
        return total;
    }


}
