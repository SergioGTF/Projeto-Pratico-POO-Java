/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaapp;

/**
 *
 * @author User
 */



public class Eletronico extends Produto {
    private String marca;
    private String modelo;

    public Eletronico(String nome, double preco, String descricao, int quantidadeEstoque, String marca, String modelo) {
        super(nome, preco, descricao, quantidadeEstoque);
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Eletronico{" +
                "nome='" + getNome() + '\'' +
                ", preco=" + getPreco() +
                ", descricao='" + getDescricao() + '\'' +
                ", quantidadeEstoque=" + getQuantidadeEstoque() +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}

 






