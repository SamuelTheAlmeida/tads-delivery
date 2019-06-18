/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Entrega;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Gustavo-Kamila
 */
public class EntregaDAO {
    public void cadastrar(Entrega entrega) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        session.save(entrega);
        session.getTransaction().commit();
        session.close();
    }
    
    public void atualizar(Entrega entrega) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        session.update(entrega);
        session.getTransaction().commit();
        session.close();
    }
    
    public void deletar(Entrega entrega) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        session.delete(entrega);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Entrega> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        Query select = session.createQuery("from Entrega");
        List<Entrega> lista = select.list();
        session.getTransaction().commit();
        session.close();
        
        return lista;
    }
}
