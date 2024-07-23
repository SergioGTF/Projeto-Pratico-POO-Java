/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaapp;

/**
 *
 * @author User
 */


import java.util.ArrayList;
import java.util.List;

public class ServicoCliente {
    private List<Cliente> clientes;

    public ServicoCliente() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente obterClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean atualizarCliente(Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equalsIgnoreCase(clienteAtualizado.getNome())) {
                clientes.set(i, clienteAtualizado);
                return true;
            }
        }
        return false;
    }

    public boolean excluirCliente(String nome) {
        return clientes.removeIf(cliente -> cliente.getNome().equalsIgnoreCase(nome));
    }
}
