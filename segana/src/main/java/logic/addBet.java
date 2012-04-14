/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
import segana.Apuesta;
import segana.Pronostico;
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
            Apuesta a=null;
            
            if (lu!=null)
            {
                if(lu.size()==1)
                {
                    u=lu.get(0);
                
                    TorneoD d=new TorneoD();
                    d.getTorneo();
                    int i=0;
                    while(i<d.ES.size())
                    {
                              
                        if(request.getParameter(d.ES.get(i).KeyEncuentro)!=null)
                        if(request.getParameter(d.ES.get(i).KeyEncuentro).equals("ON"))
                        {
                            a=new Apuesta();
                            a.setEncuentro(d.ES.get(i).encuentro);
                            a.setMonto(BigDecimal.valueOf(Double.parseDouble(request.getParameter(d.ES.get(i).encuentro.getIdencuentro()+"Monto"))));
                            a.setUsuario(u);
                            
                            Session session = HibernateUtil.getSessionFactory().openSession();
                            session.beginTransaction();
                            session.saveOrUpdate(a); 
                            
                            session.getTransaction().commit();                            
                            
                           
                            session.beginTransaction();
                            Query q = session.createQuery("FROM Apuesta WHERE  usuario_idusuario="+u.getIdusuario()+" and encuentro_idencuentro="+a.getEncuentro().getIdencuentro());
                            List<Apuesta> resultList = q.list();        
                            a=resultList.get(0);
                            session.getTransaction().commit();   
                            
                            
                            Pronostico p1=new Pronostico();
                            p1.setEquipo(d.ES.get(i).encuentro.getEquipoByEquipoIdequipo());
                            p1.setValor(Integer.parseInt(request.getParameter("E1"+d.ES.get(i).encuentro.getIdencuentro())));                            
                            p1.setApuesta(a);
                            
                            
                            Pronostico p2=new Pronostico();
                            p2.setEquipo(d.ES.get(i).encuentro.getEquipoByEquipoIdequipo1());                            
                            p2.setValor(Integer.parseInt(request.getParameter("E2"+d.ES.get(i).encuentro.getIdencuentro())));
                            p2.setApuesta(a);
                            
                            
                            
                            
                            session = HibernateUtil.getSessionFactory().openSession();
                            session.beginTransaction();
                            session.save(p1);                 
                            session.getTransaction().commit();
                            
                            session = HibernateUtil.getSessionFactory().openSession();
                            session.beginTransaction();
                            session.save(p2);                 
                            session.getTransaction().commit();
                            
                            
                            
                            //Pronostico
                            
                        }
                        i++;
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
        response.setHeader("Refresh", "1, URL=index.jsp");
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
