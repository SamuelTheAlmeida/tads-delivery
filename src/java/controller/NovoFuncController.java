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
@ManagedBean(name="NovoFuncController")
@SessionScoped
public class NovoFuncController{ 
    private Funcionario novoFunc;
    
    public NovoFuncController() {
        novoFunc = new Funcionario();
    }        
        
    public String salvar() {
        FuncionarioDAO dao = new FuncionarioDAO();
        String cpf = this.novoFunc.getCpf().replaceAll("[^a-zA-Z0-9]+","");
        this.novoFunc.setCpf(cpf);

        if (dao.cpfExiste(novoFunc.getCpf())) {
            FacesContext.getCurrentInstance().addMessage("cadastrar:erroCadastro", new FacesMessage("CPF já cadastrado"));
            return null;
        }
        
        if (dao.emailExiste(novoFunc.getEmail())) {
            FacesContext.getCurrentInstance().addMessage("cadastrar:erroCadastro", new FacesMessage("Email já cadastrado"));
            return null;
        }
        
        String telefone = this.novoFunc.getTelefone().replaceAll("[^a-zA-Z0-9]+","");
        this.novoFunc.setTelefone(telefone);

        dao.cadastrar(novoFunc);
        return "visualizarEntregas?faces-redirect=true";        
    }
    
    public Funcionario getNovoFunc() {
        return novoFunc;
    }

    public void setNovoFunc(Funcionario novoFunc) {
        this.novoFunc = novoFunc;
    }
}
