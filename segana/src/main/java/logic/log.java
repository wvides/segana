package logic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.omg.CORBA.ULongLongSeqHelper;
import segana.Rol;
import segana.Rolusuario;
import segana.Usuario;

/**
 *
 * @author Omar
 */
@WebServlet(name = "log", urlPatterns = {"/log"})
public class log extends HttpServlet {

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
            //comentario
            List<Usuario>  myuser = validateuser(request.getParameter("email"));
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet log</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet log at " + request.getContextPath() + "</h1>");
            //out.println("<br/> requested: " + request.getParameter("username"));
            out.println("Esta pagina lo redirigira al inicio en 5 segundos <br/> O puede hacer click en el siguiente enlace");
            out.println("para volver al inicio <a href=\"index.jsp\">Inicio</a>");
            Rol myrol = new Rol();
            Usuario tmpo = new Usuario();
            if(myuser.isEmpty())
            {
                String dat = request.getParameter("anio") + "/" + request.getParameter("mes") + "/" + request.getParameter("dia");
                java.util.Date utilDate = null;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                try {
                    utilDate = formatter.parse(dat);
                } catch (ParseException ex) {
                    Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Usuario u = new Usuario(); 
                u.setNombre(request.getParameter("username"));
                u.setPassword(request.getParameter("password"));
                u.setEmail(request.getParameter("email"));
                u.setFechaNac(utilDate);
                u.setDireccion(request.getParameter("address"));
                u.setTarjeta(request.getParameter("tarjeta"));                                    
                
                myrol = retrieverol("cliente");
                
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(u);
                session.getTransaction().commit();   
                tmpo = retrieveuser(u.getEmail());
                
                Rolusuario ux = new Rolusuario();
                ux.setRol(myrol);
                ux.setUsuario(tmpo);
                session.beginTransaction();
                session.getTransaction();
                session.save(ux);
                session.getTransaction().commit();
                
            }
            else
            {
                response.sendRedirect("error.jsp?err=0");                
            }
            response.setHeader("Refresh", "5, URL=index.jsp");
            
            
            out.println("</body>");            
            out.println("</html>");            
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

    private List<Usuario> filmaker() 
    {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Usuario");
        List<Usuario> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList;
    }

    private List<Usuario> validateuser(String parameter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Usuario WHERE email LIKE'" + parameter + "'");
        List<Usuario> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList;
    }

    private Rol retrieverol(String cliente) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Rol where descripcion like '"+cliente+"'");
        List<Rol> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList.get(0);
    }

    private Usuario retrieveuser(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Usuario where email like '"+email+"'");
        List<Usuario> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList.get(0);
    }

}
