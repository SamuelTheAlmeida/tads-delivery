package controller;

import dao.EntregaDAO;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import model.Entrega;
import org.hibernate.Query;
import util.HibernateUtil;
import org.hibernate.Session;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.StatusEntrega;

@ManagedBean(name="EntregaController")
@SessionScoped
public class EntregaController {
    @javax.faces.bean.ManagedProperty(value="#{loginMB}")
    private LoginMB loginMB;
    private Entrega entrega = new Entrega();
    private List<Entrega> entregas = new ArrayList<Entrega>();
    private DataModel<Entrega> entregasDataModel;
    
    public EntregaController() {
        entrega = new Entrega();
    }
    
    public String cadastrarEntrega(){        
        EntregaDAO dao = new EntregaDAO();
        this.entrega.setIdStatusEntrega(util.Constantes.STATUS_AGUARDANDO);
        
        java.util.Date dt = this.entrega.getDataEntrega();
        java.util.Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(java.util.Calendar.DATE, 1);
        dt = c.getTime();
        this.entrega.setDataEntrega(dt);
        
        dao.cadastrar(entrega);
        
        return "visualizarEntregas?faces-redirect=true";
    }
    
    public void listar() {
        this.entregas = new EntregaDAO().listar();
        entregasDataModel = new ListDataModel<Entrega>(this.entregas);
    }
    
    public String atribuirEntrega() {
        this.entrega.setIdFunc(loginMB.getFuncionario());
        this.entrega.setIdStatusEntrega(2);
        new EntregaDAO().atualizar(this.entrega);
        return null;
    }
    
    public Entrega getEntrega() {
        return entrega;
    }

    public List<Entrega> getEntregas() {
        listar();
        return this.entregas;
    }
    
     public LoginMB getLoginMB() {
        return loginMB;
    }

    public void setLoginMB(LoginMB loginMB) {
        this.loginMB = loginMB;
    }

    public DataModel<Entrega> getEntregasDataModel() {
        listar();
        return entregasDataModel;
    }

    public void setEntregasDataModel(DataModel<Entrega> entregasDataModel) {
        this.entregasDataModel = entregasDataModel;
    }
}
