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
import model.dbaccess;
import org.hibernate.Query;
import org.hibernate.Session;
import segana.Tarjeta;
import segana.Usuario;

/**
 *
 * @author Eddy
 */
@WebServlet(name = "addcard", urlPatterns = {"/addcard"})
public class addcard extends HttpServlet {

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
            
//            String nombre =session
            List <Usuario> lu=null; 
            lu=database.validateforcard(request.getParameter("username"));
            Usuario u=null;
            if (lu!=null)
            {
                if(lu.size()==1)
                {
                    u=lu.get(0);
                
            
            
            
            if(u!=null)
            {
                Tarjeta tr= new Tarjeta();
                String fechaVencimiento=request.getParameter("anio")+"/"+request.getParameter("mes")+"/"+"01";
                
                java.util.Date utilDate = null;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                try {
                    utilDate = formatter.parse(fechaVencimiento);
                } catch (ParseException ex) {
                    Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
                }
                tr.setFechaVence(utilDate);
                tr.setNombre(request.getParameter("typeCard"));
                tr.setUsuario(u);
                tr.setDescripcion(request.getParameter("notarjeta"));
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(tr);
                session.getTransaction().commit();
                
                
                response.setHeader("Refresh", "5, URL=index.jsp");
            }
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
