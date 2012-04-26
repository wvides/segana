/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import segana.Rol;
import segana.Rolusuario;
import segana.Usuario;

/**
 *
 * @author Omar
 */
@WebServlet(name = "modify", urlPatterns = {"/modify"})
public class modify extends HttpServlet {

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
            List<Usuario> myu = getusers();
            Iterator mu = myu.iterator();            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modify Users Access</title>");            
            out.println("<h1>Modify Users Access</h1>");
            out.println("</head>");
            out.println("<body>");            
            int count = 1;
            out.println("<form action=\"mod\"> <table border=\"1\"><tbody>");
            out.println("<tr>");
            out.println("<tr><td>Modificar</td><td>Usuario</td><td>Correo</td><td>Rol</td></tr>");
            out.println("</tr>");
            while(mu.hasNext())
            {                
                out.println("<tr>");
                Usuario xd = (Usuario) mu.next();
                Rol myrol = getmyrol(xd.getIdusuario());
                
                out.println("<td><input type=\"checkbox\" name=\""+xd.getIdusuario()+"\" value=\"OFF\" /></td>" + "<td>" + xd.getNombre() 
                        + "</td> <td> " + xd.getEmail() + "</td><td>" + myrol.getDescripcion() + "</td>" );                                  
                count++;
                out.println("</tr>");
            }
             out.println("<td>Administrator <input type=\"checkbox\" name=\"admin\" value=\"ON\" /></td>"
                    + "<td>Moderator <input type=\"checkbox\" name=\"moderator\" value=\"ON\" /></td>"
                    + "<td>Corredor<input type=\"checkbox\" name=\"corred\" value=\"ON\" /></td>"
                    + "<td>Client <input type=\"checkbox\" name=\"user\" value=\"ON\" /></td>");
            
            out.println("</tbody></table>");
            
            out.println(""
                    + "<br/>"                    
                    +"<input type=\"submit\" value=\"Modificar roles\" />"
                    + "</form>");
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
        //verificando que mi commit aun sirva
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

    private List<Usuario> getusers() 
    {                
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Usuario");
        List<Usuario> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList;    
    }

    private Rol getmyrol(int us) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Rolusuario where usuario_idusuario = " + us);
        List<Rolusuario> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList.get(0).getRol();    
    }
}
