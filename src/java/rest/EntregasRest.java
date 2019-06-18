/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.sun.mail.iap.Response;
import dao.EntregaDAO;
import java.text.SimpleDateFormat;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import model.Entrega;
import model.StatusEntrega;
import org.json.JSONException;
import org.json.JSONObject;

@javax.ws.rs.Path("/delivery")
public class EntregasRest {
    @javax.ws.rs.POST
    @javax.ws.rs.Consumes(MediaType.APPLICATION_JSON)
    @Path("/cadastrarEntrega")
    public int cadastrarEntrega(String json) {
        Entrega entrega = new Entrega();
        entrega.setIdStatusEntrega(util.Constantes.STATUS_AGUARDANDO);
        JSONObject jsonObject = new JSONObject(json);
        if (jsonObject.getString("descricao").length() > 0) {
            entrega.setDescricao(jsonObject.getString("descricao"));
        }
        if (jsonObject.getString("endereco").length() > 0) {
            entrega.setEnderecoEntrega(jsonObject.getString("endereco"));
        }    
        if (jsonObject.getString("destinatario").length() > 0) {
            entrega.setDestinatario(jsonObject.getString("destinatario"));
        }  
        if (jsonObject.getString("dataCadastro").length() > 0) {
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String data = jsonObject.getString("dataCadastro");
            try {
                java.util.Date date = formatter.parse(data);
                entrega.setDataEntrega(date);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            } 
        }          
        
        new EntregaDAO().cadastrar(entrega);
        
        return Response.OK;
    }
}
