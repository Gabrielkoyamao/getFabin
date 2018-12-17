package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*classe para conectar com o banco */
public class ConexaoBD {
    
    protected static final String DRIVER = "org.mariadb.jdbc.Driver";
    protected static final String URL = "jdbc:mysql://localhost:3306/LUCAS";
    protected static final String usuario = "gabrielk";
    protected static final String senha = "amayok132";
    protected static Connection conn;
    
    //metodo para conectar com o banco
    public Connection conectandoBanco(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,usuario,senha);
            
        } catch ( ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao: ", ex);
        } 
        return conn;
    }
    
    //metodo para fechar as propriedades do banco
    protected void fechaBanco(Connection con, PreparedStatement pst, ResultSet rs){
        
        try{
            if(con != null){
                con.close();
            }
            
            if(pst != null){
                pst.close();
            }
            
            if(rs != null){
                rs.close();
            }
                
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar conexao banco: ", ex);
            }
    }
}