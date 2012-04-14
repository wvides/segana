/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import segana.Tarjeta;
import segana.Usuario;

/**
 *
 * @author eddytrex
 */
@WebServlet(name = "addBet", urlPatterns = {"/addBet"})
public class addBet extends HttpServlet {
     /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            
//            String nombre =session
            List <Usuario> lu=null; 
            lu=validate(request.getParameter("username"));
            Usuario u=null;
            if (lu!=null)
            {
                if(lu.size()==1)
                {
                    u=lu.get(0);
                
                        
            
            
         
            }
            }
            else
            {
                response.sendRedirect("error.jsp?err=0");                

            }          
            
            
        } finally {            
            out.close();
        }
    }
    
     private List<Usuario> validate(String email) 
    {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Usuario WHERE email LIKE '" + email+"'");
        List<Usuario> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList;
    }
}
