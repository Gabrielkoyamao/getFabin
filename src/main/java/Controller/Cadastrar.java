/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.UsuarioDAO;
import daoImpl.UsuarioDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author gabrielk
 */
@WebServlet(urlPatterns = {"/cadastrar"})
public class Cadastrar extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
        ServletContext sc = request.getServletContext();
        
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
      
        UsuarioDAO cadastraUsuario;
        cadastraUsuario = new UsuarioDaoImpl();
        
        System.out.println("CADASTRO :: " + nome + ", " + senha);
        
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setSenha(senha);
        
        boolean status = false;
        status = cadastraUsuario.inserir(u);
        
        System.out.println("CADASTRO :: " + nome + ", " + senha + ", " + status);
        
        if(status){
            sc.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }else {
            request.setAttribute("erroNoCadastro", 1);
            sc.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
        
    }
}