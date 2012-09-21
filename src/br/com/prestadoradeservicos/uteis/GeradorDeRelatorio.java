package br.com.prestadoradeservicos.uteis;


import br.com.prestadoradeservicos.conexoes.FabricaDeConexoes;
import java.sql.*;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Anderson Luis Ribeiro
 */
public class GeradorDeRelatorio {
    
    private String nomeDoRelatorio;
    private static Connection con = null;   
    private Map parameters = null;

    
    /**
     * @return the nomeDoRelatorio
     */
    public String getNomeDoRelatorio() {
        return nomeDoRelatorio;
    }

    /**
     * @param nomeDoRelatorio the nomeDoRelatorio to set
     */
    public void setNomeDoRelatorio(String nomeDoRelatorio) {
        this.nomeDoRelatorio = nomeDoRelatorio;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    @SuppressWarnings("static-access")
    public void setCon(Connection con) {
        this.con = con;
    }    

    /**
     * @return the parameters
     */
    public Map getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }

    public void gerarRelatorio() throws SQLException{
        

        setCon(FabricaDeConexoes.getConexao());        

        try{           

           JasperReport jr = JasperCompileManager.compileReport(getClass().getResourceAsStream("/" + getNomeDoRelatorio() + ".jrxml"));

           JasperPrint impressao = JasperFillManager.fillReport(jr, getParameters(), getCon());

           JasperViewer.viewReport(impressao, false);


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            getCon().close();            
        }
                                                                  
       

    }           
    

}
