/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Entrega;
import model.Funcionario;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Gustavo-Kamila
 */
public class FuncionarioDAO {
    public void cadastrar(Funcionario funcionario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        session.save(funcionario);
        session.getTransaction().commit();
        session.close();
    }
    
    public void atualizar(Funcionario funcionario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        session.update(funcionario);
        session.getTransaction().commit();
        session.close();
    }
    
    public void deletar(Funcionario funcionario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        session.delete(funcionario);
        session.getTransaction().commit();
        session.close();
    }    
    
    public List<Funcionario> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        Query select = session.createQuery("from Funcionario");
        List<Funcionario> lista = select.list();
        session.getTransaction().commit();
        session.close();
        
        return lista;
    }
    
    public Funcionario autenticar(Funcionario funcionario) {
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        Query select = session.createQuery("from Funcionario where login = ? and UPPER(senha) = UPPER(?)");
        select.setString(0, funcionario.getLogin());
        select.setString(1, funcionario.getSenha());
        Funcionario funcResult = (Funcionario)select.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return funcResult;       
   }
    
   public boolean cpfExiste(String cpf) {
        System.out.println(cpf);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        Query select = session.createQuery("from Funcionario where cpf = ?");
        select.setString(0, cpf);
        List<Funcionario> lista = select.list();
        session.getTransaction().commit();
        session.close();
        return lista.size() > 0;
   }
   
   public boolean emailExiste(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        Query select = session.createQuery("from Funcionario where email = ?");
        select.setString(0, email);
        List<Funcionario> lista = select.list();
        session.getTransaction().commit();
        session.close();
        return lista.size() > 0;
   }
    
}
