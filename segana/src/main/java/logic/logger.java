/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dbaccess;
import org.hibernate.Query;
import org.hibernate.Session;
import segana.Rol;
import segana.Rolusuario;
import segana.Usuario;

/**
 *
 * @author Omar
 */
@WebServlet(name = "logger", urlPatterns = {"/logger"})
public class logger extends HttpServlet {

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
        dbaccess database = new dbaccess();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */            
            HttpSession sess = request.getSession(true);
            //comment
            List<Usuario> u = null;
            u = database.validate(request.getParameter("email"),request.getParameter("password"));
            out.print("Email: " + request.getParameter("email") + " Password: " + request.getParameter("password") );
            //if null comment to test
            if(u != null)
            {
                Usuario m = new Usuario();                
                try
                {
                    m = u.get(0);
                }
                catch(Exception mx)
                {
                    response.sendRedirect("error.jsp?err=1");
                }                
                
                Set<Rolusuario> ad = m.getRolusuarios();
                Iterator k = ad.iterator();
                while(k.hasNext())
                {
                    Rolusuario um =  (Rolusuario) k.next();
                    if(um.getRol().getDescripcion().equalsIgnoreCase("admin"))
                    {
                        sess.setAttribute("admin", true);                        
                    }
                    else if(um.getRol().getDescripcion().equalsIgnoreCase("moderador"))
                    {
                        sess.setAttribute("moderador", true);
                    }
                    else if(um.getRol().getDescripcion().equalsIgnoreCase("corredor"))
                    {
                        sess.setAttribute("corredor", true);
                    }
                }
                sess.setAttribute("namen", m.getEmail());
                if(sess.getAttribute("admin") != null)
                {
                    response.setHeader("Refresh", "0, URL=admin.jsp");
                }
                else
                {
                    response.setHeader("Refresh", "0, URL=index.jsp");
                }                                
            }
            else
            {                
                response.sendRedirect("error.jsp?err=1");
            }
            
                        
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
