/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
import util.Utils;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Funcionario;

/**
 *
 * @author Gustavo-Kamila
 */
@SessionScoped
@ManagedBean(name="loginMB")
public class LoginMB {
    private Funcionario funcionario = new Funcionario();

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public String autenticar() {
        FacesContext context = FacesContext.getCurrentInstance();
        FuncionarioDAO dao = new FuncionarioDAO();
        String senha = this.funcionario.getSenha();
        this.funcionario.setSenha(Utils.MD5(senha));
        this.funcionario = dao.autenticar(funcionario);
        if (this.funcionario != null) {
            return "visualizarEntregas?faces-redirect=true";
        } else {
            this.funcionario = new Funcionario();
            context.addMessage(null, new FacesMessage("Login ou senha incorretos"));  
            return null;
        }
    }
    
    public boolean isLogado() {
        return funcionario.getLogin() != null;
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().
        getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
}
