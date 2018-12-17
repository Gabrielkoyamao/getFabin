package dao;

import model.Usuario;

public interface UsuarioDAO {
    public boolean inserir(Usuario u);
    public boolean findByName(String name, String senha);
    public boolean excluir(int valor);
    public boolean editar(int valor);
    
    
}
