/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.HashMap;
import static util.Perfil.PERFIL_ENTREGADOR;
import static util.Perfil.PERFIL_GERENTE;

/**
 *
 * @author SAMUEL
 */
public class Constantes {
    public static final int STATUS_AGUARDANDO = 1;
    public static final int STATUS_EM_ENTREGA = 2;
    public static final int STATUS_ENTREGUE = 3;
    public static final int STATUS_NAO_ENTREGUE = 4;    
    public static final int STATUS_CANCELADO = 5;
    
    public static final java.util.HashMap<Integer, String> STATUS_PEDIDO = new HashMap<>();
    static {
        STATUS_PEDIDO.put(STATUS_AGUARDANDO, "Aguardando");
        STATUS_PEDIDO.put(STATUS_EM_ENTREGA, "Em entrega");
        STATUS_PEDIDO.put(STATUS_ENTREGUE, "Entregue");
        STATUS_PEDIDO.put(STATUS_NAO_ENTREGUE, "Não entregue");
        STATUS_PEDIDO.put(STATUS_CANCELADO, "Cancelado");
    }    
}
