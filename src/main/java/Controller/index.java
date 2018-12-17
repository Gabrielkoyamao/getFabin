package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDAO;
import daoImpl.UsuarioDaoImpl;
import model.Usuario;
        
        
@WebServlet(urlPatterns = {"/"})
public class index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, ServletException, IOException{
           
        ServletContext sc = request.getServletContext();
        sc.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }
}

