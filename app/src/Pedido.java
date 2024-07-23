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
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Produto> itens;
    private double total;
    private String status;
    private Date dataPedido;
    private String infoPagamento;
    private String infoEntrega;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0;
        this.status = "Pendente";
        this.dataPedido = new Date();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
        this.total += produto.getPreco();
    }

    public void removerItem(Produto produto) {
        if (itens.remove(produto)) {
            this.total -= produto.getPreco();
        }
    }

    public double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public String getInfoPagamento() {
        return infoPagamento;
    }

    public void setInfoPagamento(String infoPagamento) {
        this.infoPagamento = infoPagamento;
    }

    public String getInfoEntrega() {
        return infoEntrega;
    }

    public void setInfoEntrega(String infoEntrega) {
        this.infoEntrega = infoEntrega;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", itens=" + itens +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", dataPedido=" + dataPedido +
                ", infoPagamento='" + infoPagamento + '\'' +
                ", infoEntrega='" + infoEntrega + '\'' +
                '}';
    }

}
