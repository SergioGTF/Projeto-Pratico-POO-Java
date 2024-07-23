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

public class ServicoProduto {
    private final List<Produto> produtos;

    public ServicoProduto() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto obterProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public boolean atualizarProduto(Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(produtoAtualizado.getNome())) {
                produtos.set(i, produtoAtualizado);
                return true;
            }
        }
        return false;
    }

    public boolean excluirProduto(String nome) {
        return produtos.removeIf(produto -> produto.getNome().equalsIgnoreCase(nome));
    }
}
