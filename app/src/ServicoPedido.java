/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ServicoPedido {
    
    private final List<Pedido> pedidos;
    private int proximoId;

    public ServicoPedido() {
        pedidos = new ArrayList<>();
        proximoId = 1;
        
    }

    public void adicionarPedido(Pedido pedido) {
        pedido.setId(proximoId++);
        pedidos.add(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public Pedido obterPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public boolean atualizarPedido(Pedido pedidoAtualizado) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId() == pedidoAtualizado.getId()) {
                pedidos.set(i, pedidoAtualizado);
                return true;
            }
        }
        return false;
    }

    public boolean excluirPedido(int id) {
        return pedidos.removeIf(pedido -> pedido.getId() == id);
    }
}
