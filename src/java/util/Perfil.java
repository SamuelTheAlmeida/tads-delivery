/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.HashMap;

/**
 *
 * @author Gustavo-Kamila
 */
public final class Perfil {
    public static final int PERFIL_GERENTE = 1;
    public static final int PERFIL_ENTREGADOR = 2;

    public static final java.util.HashMap<Integer, String> STATUS_PEDIDO = new HashMap<>();
    static {
        STATUS_PEDIDO.put(PERFIL_GERENTE, "Gerente");
        STATUS_PEDIDO.put(PERFIL_ENTREGADOR, "Entregador");
    }
}
