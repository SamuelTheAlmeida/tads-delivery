/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Funcionario;
import util.Utils;

/**
 *
 * @author Gustavo-Kamila
 */
@ManagedBean(name="FuncionarioController")
@SessionScoped
public class FuncionarioController {
    private Funcionario funcionarioLogin;
    
    public FuncionarioController() {
        funcionarioLogin = new Funcionario();
    }
    
//    public String autenticar() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        FuncionarioDAO dao = new FuncionarioDAO();
//        String senha = this.funcionarioLogin.getSenha();
//        this.funcionarioLogin.setSenha(MD5(senha));
//        if (dao.autenticar(funcionarioLogin)) {
//            context.getExternalContext().getSessionMap().put("usuario", this.funcionarioLogin);
//            return "entregas";
//        } else {
//            context.addMessage(null, new FacesMessage("Login ou senha incorretos"));  
//            return null;
//        }
//    }
    
    
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

    public Funcionario getFuncionarioLogin() {
        return funcionarioLogin;
    }

    public void setFuncionarioLogin(Funcionario funcionarioLogin) {
        this.funcionarioLogin = funcionarioLogin;
    }
}
