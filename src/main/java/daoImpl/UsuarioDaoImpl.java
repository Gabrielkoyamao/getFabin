package daoImpl;

import com.mysql.jdbc.PreparedStatement;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDaoImpl implements UsuarioDAO{
    
    private Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    public UsuarioDaoImpl(){
        con = new ConexaoBD().conectandoBanco();
    }

    @Override
    public boolean inserir(Usuario usuario) {
        String sql ="INSERT INTO usuario(nome, senha) VALUES(?,?)";
        
        try{
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getSenha());
            pst.execute();
            pst.close();
            
            return true;
            
        }catch(Exception erro){
            throw new RuntimeException("erro ao inserir usuario"+erro);
        }
    }
    
    @Override
    public boolean findByName(String nome, String senha) {
        String sql ="SELECT * FROM usuario WHERE nome = (?) AND senha = (?)";
        
        try{
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, senha);
            pst.execute();
            pst.close();
            
            return true;
            
        }catch(Exception erro){
            throw new RuntimeException("erro ao inserir usuario"+erro);
        }
    }
    
    @Override
    public boolean excluir(int valor) {
        String sql ="DELETE FROM produto WHERE codigo_produto = " +valor;
        
        try{
            st = con.createStatement();
            st.execute(sql);
            st.close();
            return true;
        }catch(Exception erro4){
            throw new RuntimeException("erro ao deletar usuario"+erro4);
        }
    }

    @Override
    public boolean editar(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}