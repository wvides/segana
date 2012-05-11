/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import logic.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import segana.Rol;
import segana.Usuario;

/**
 *
 * @author Omar
 */
public class dbaccess {
    
    public List<Usuario> validate(String email, String password) 
    {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Usuario WHERE email LIKE '" + email + "' AND password LIKE '" + password + "'");
        List<Usuario> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList;
    }
    
    public List<Usuario> validateuser(String parameter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Usuario WHERE email LIKE'" + parameter + "'");
        List<Usuario> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList;
    }
    
    public Rol retrieverol(String cliente) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Rol where descripcion like '"+cliente+"'");
        List<Rol> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList.get(0);
    }
    public Usuario retrieveuser(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Usuario where email like '"+email+"'");
        List<Usuario> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList.get(0);
    }
    public List<Usuario> validateforcard(String email) 
    {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM Usuario WHERE email LIKE '" + email+"'");
        List<Usuario> resultList = q.list();        
        session.getTransaction().commit();   
        return resultList;
    }
}