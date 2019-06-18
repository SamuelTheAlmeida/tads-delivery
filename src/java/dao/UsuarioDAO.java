/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Gustavo-Kamila
 */
public class UsuarioDAO {
    public boolean autenticar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        Query select = session.createQuery("from tb_usuario where login = ? and senha = ?");
        select.setString(0, usuario.getLogin());
        select.setString(1, usuario.getSenha());
        List<Usuario> lista = select.list();
        session.getTransaction().commit();
        session.close();
        return lista.size() > 0;       
   }
}
