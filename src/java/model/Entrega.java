/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import util.Constantes;

/**
 *
 * @author Gustavo-Kamila
 */
@javax.persistence.Entity
@javax.persistence.Table(name="tb_entrega")
@AssociationOverrides({
		@AssociationOverride(name = "tb_funcionario", 
			joinColumns = @JoinColumn(name = "idFunc")),
                })
public class Entrega implements Serializable{
    private Integer idEntrega;
    private Date dataEntrega;
    private String enderecoEntrega;
    private String destinatario;
    private String descricao;
    private String motivo;
    private Funcionario idFunc;
    private int idStatusEntrega;

    public Entrega() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @ManyToOne
    @JoinColumn(name = "idFunc", referencedColumnName = "idFunc")
    public Funcionario getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Funcionario idFunc) {
        this.idFunc = idFunc;
    }

    public int getIdStatusEntrega() {
        return idStatusEntrega;
    }

    public void setIdStatusEntrega(int idStatusEntrega) {
        this.idStatusEntrega = idStatusEntrega;
    }
    
    @Transient
    public String getDataFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.dataEntrega);
    }
    
    @Transient
    public String getStatus() {
        return Constantes.STATUS_PEDIDO.get(this.idStatusEntrega);
    }

}
