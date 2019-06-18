/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

/**
 *
 * @author Gustavo-Kamila
 */
@javax.persistence.Entity
@javax.persistence.Table(name="Usuario")
@AssociationOverrides({
		@AssociationOverride(name = "Funcionario", 
			joinColumns = @JoinColumn(name = "idUsuario"))})
public class Usuario {
    Funcionario idUsuario;
    String login;
    String senha;

    public Usuario() {
    }

    @Id
    @Transient
    public Funcionario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Funcionario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
