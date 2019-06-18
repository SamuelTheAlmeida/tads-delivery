/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Usuario;

/**
 *
 * @author Gustavo-Kamila
 */
public class UsuarioController {
    private Usuario usuarioLogin;
    
    public UsuarioController() {
        usuarioLogin = new Usuario();
    }
    
    public String autenticar() {
        FacesContext context = FacesContext.getCurrentInstance();
        UsuarioDAO dao = new UsuarioDAO();
        String senha = this.usuarioLogin.getSenha();
        this.usuarioLogin.setSenha(MD5(senha));
        if (dao.autenticar(usuarioLogin)) {
            context.getExternalContext().getSessionMap().put("usuario", this.usuarioLogin);
            return "entregas";
        } else {
            context.addMessage(null, new FacesMessage("Login ou senha incorretos"));  
            return null;
        }
    }
    
    public String MD5(String md5) {
        try {
             java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
             byte[] array = md.digest(md5.getBytes());
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < array.length; ++i) {
               sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
             return sb.toString();
         } catch (java.security.NoSuchAlgorithmException e) {
         }
         return null;
    }

    public Usuario getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(Usuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }
}
