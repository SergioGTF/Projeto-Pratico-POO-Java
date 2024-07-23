/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lojaapp;

/**
 *
 * @author User
 */


import java.util.List;
import java.util.Scanner;

public class LojaApp {

    private static ServicoProduto servicoProduto = new ServicoProduto();
    private static ServicoCliente servicoCliente = new ServicoCliente();
    private static ServicoPedido servicoPedido = new ServicoPedido();
    
    
    /**
     * @param args the command line arguments
     */
    
    
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("==== Sistema de Comércio Eletrônico ====");
            System.out.println("1. Gestao de Produtos");
            System.out.println("2. Gestao de Clientes");
            System.out.println("3. Gestao de Pedidos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            switch (choice) {
                case 1:
                    gerenciarProdutos(scanner);
                    break;
                case 2:
                    gerenciarClientes(scanner);
                    break;
                case 3:
                    gerenciarPedidos(scanner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarProdutos(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("==== Gestão de Produtos ====");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            switch (choice) {
                case 1:
                    adicionarProduto(scanner);
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarProduto(scanner);
                    break;
                case 4:
                    excluirProduto(scanner);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarProduto(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consuming newline character
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Quantidade em Estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        scanner.nextLine(); // Consuming newline character
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        Produto produto = new Eletronico(nome, preco, descricao, quantidadeEstoque, marca, modelo);

        servicoProduto.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso.");
    }

    private static void listarProdutos() {
        List<Produto> produtos = servicoProduto.listarProdutos();
        System.out.println("==== Lista de Produtos ====");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private static void atualizarProduto(Scanner scanner) {
        System.out.print("Nome do Produto a Atualizar: ");
        String nome = scanner.nextLine();
        Produto produto = servicoProduto.obterProdutoPorNome(nome);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Novo Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consuming newline character
        System.out.print("Nova Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Nova Quantidade em Estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        scanner.nextLine(); // Consuming newline character
        System.out.print("Nova Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Novo Modelo: ");
        String modelo = scanner.nextLine();

        if (produto instanceof Eletronico) {
            ((Eletronico) produto).setMarca(marca);
            ((Eletronico) produto).setModelo(modelo);
        }

        produto.setPreco(preco);
        produto.setDescricao(descricao);
        produto.setQuantidadeEstoque(quantidadeEstoque);

        servicoProduto.atualizarProduto(produto);
        System.out.println("Produto atualizado com sucesso.");
    }

    private static void excluirProduto(Scanner scanner) {
        System.out.print("Nome do Produto a Excluir: ");
        String nome = scanner.nextLine();
        boolean sucesso = servicoProduto.excluirProduto(nome);
        if (sucesso) {
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void gerenciarClientes(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("==== Gestão de Clientes ====");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            switch (choice) {
                case 1:
                    adicionarCliente(scanner);
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    atualizarCliente(scanner);
                    break;
                case 4:
                    excluirCliente(scanner);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarCliente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Informações de Contato: ");
        String contato = scanner.nextLine();

        Cliente cliente = new Cliente(nome, endereco, contato);
        servicoCliente.adicionarCliente(cliente);
        System.out.println("Cliente adicionado com sucesso.");
    }

    private static void listarClientes() {
        List<Cliente> clientes = servicoCliente.listarClientes();
        System.out.println("==== Lista de Clientes ====");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private static void atualizarCliente(Scanner scanner) {
        System.out.print("Nome do Cliente a Atualizar: ");
        String nome = scanner.nextLine();
        Cliente cliente = servicoCliente.obterClientePorNome(nome);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Novo Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Novas Informações de Contato: ");
        String contato = scanner.nextLine();

        cliente.setEndereco(endereco);
        cliente.setContato(contato);

        servicoCliente.atualizarCliente(cliente);
        System.out.println("Cliente atualizado com sucesso.");
    }

    private static void excluirCliente(Scanner scanner) {
        System.out.print("Nome do Cliente a Excluir: ");
        String nome = scanner.nextLine();
        boolean sucesso = servicoCliente.excluirCliente(nome);
        if (sucesso) {
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void gerenciarPedidos(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("==== Gestão de Pedidos ====");
            System.out.println("1. Criar Pedido");
            System.out.println("2. Listar Pedidos");
            System.out.println("3. Atualizar Status do Pedido");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            switch (choice) {
                case 1:
                    criarPedido(scanner);
                    break;
                case 2:
                    listarPedidos();
                    break;
                case 3:
                    atualizarStatusPedido(scanner);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarPedido(Scanner scanner) {
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = servicoCliente.obterClientePorNome(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Pedido pedido = new Pedido(cliente);
        boolean adicionandoItens = true;

        while (adicionandoItens) {
            System.out.print("Nome do Produto a Adicionar: ");
            String nomeProduto = scanner.nextLine();
            Produto produto = servicoProduto.obterProdutoPorNome(nomeProduto);
            if (produto == null) {
                System.out.println("Produto não encontrado.");
            } else {
                pedido.adicionarItem(produto);
                System.out.println("Produto adicionado ao pedido.");
            }

            System.out.print("Adicionar mais itens? (s/n): ");
            String addMore = scanner.nextLine();
            if (addMore.equalsIgnoreCase("n")) {
                adicionandoItens = false;
            }
        }

        servicoPedido.adicionarPedido(pedido);
        cliente.adicionarPedido(pedido);
        System.out.println("Pedido criado com sucesso.");
    }

    private static void listarPedidos() {
        List<Pedido> pedidos = servicoPedido.listarPedidos();
        System.out.println("==== Lista de Pedidos ====");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    private static void atualizarStatusPedido(Scanner scanner) {
        System.out.print("ID do Pedido a Atualizar: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); 
        Pedido pedido = servicoPedido.obterPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.print("Novo Status: ");
        String status = scanner.nextLine();
        pedido.setStatus(status);
        servicoPedido.atualizarPedido(pedido);
        System.out.println("Status do pedido atualizado com sucesso.");
    }
}