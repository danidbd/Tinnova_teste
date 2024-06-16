package org.example.example;

import org.example.AppDesconto;
import org.example.CalcularTotal;
import org.example.ExibirProduto;
import org.example.RegistrarProduto;

import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        HashMap<String, Integer> carrinho = new HashMap<>();
        HashMap<String, Double> precos = new HashMap<>();

        RegistrarProduto registrarProduto = new RegistrarProduto();
        CalcularTotal calcularTotal = new CalcularTotal();
        AppDesconto appDesconto = new AppDesconto();
        ExibirProduto exibirProduto = new ExibirProduto();

        //ADD OS PRODUTOS

        precos.put("Maçã", 2.5);
        precos.put("Banana", 1.8);
        precos.put("Laranja", 3.0);
        precos.put("Pêra", 2.0);

        Scanner scanner = new Scanner(System.in);
        boolean continuarComprando = true;

        while (continuarComprando) {
            System.out.println("Produtos disponíveis:");
            for (String produto : precos.keySet()) {
                System.out.println("- " + produto);
            }

            System.out.print("Escolha um produto para adicionar ao carrinho, caso seu produto não esteja na lista basta colocar o nome dele  (ou digite 'sair' para encerrar): ");
            String escolha  = scanner.nextLine();

            if (precos.containsKey(escolha)){
                System.out.print("Quantidade:");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                registrarProduto.adicionarProduto(escolha, precos.get(escolha), quantidade, carrinho);
                System.out.println("Produto adicionado ao carrinho.");

            }else if (escolha.equalsIgnoreCase("sair")){
                continuarComprando = false;

            }else {
                // Se o produto não estiver na lista, pedir para o usuário inserir o preço
                System.out.print("Produto não encontrado. Digite o preço do produto: ");
                double preco = scanner.nextDouble();
                scanner.nextLine(); // Consumir a nova linha pendente após nextDouble()
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha pendente após nextInt()

                precos.put(escolha, preco); // Adicionar o novo produto à lista de preços
                registrarProduto.adicionarProduto(escolha, preco, quantidade, carrinho); // Adicionar ao carrinho
                System.out.println("Novo produto adicionado ao carrinho.");
            }

            //Mostrando Produto no carrinho
            exibirProduto.exibirProdutos(carrinho, precos);

            //calculartotal
            double totalSemDesconto = calcularTotal.calcularTotal(carrinho, precos);
            System.out.println("Total (sem desconto): " + totalSemDesconto);

            // APPdesconto

            double desconto = 10.0; //10% de desconto
            double totalComDesconto = appDesconto.aplicarDesconto(totalSemDesconto , desconto);
            System.out.println("Total com desconto de " + desconto + "%: " + totalComDesconto);

        }
    }
}
