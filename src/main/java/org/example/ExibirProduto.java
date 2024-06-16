package org.example;
import java.util.HashMap;

public class ExibirProduto {

    public void exibirProdutos(HashMap<String, Integer> carrinho, HashMap<String, Double> precos) {

        System.out.println("Produtos no Carrinho:");

        for (String produto : carrinho.keySet()) {
            int quantidade = carrinho.get(produto);
            double preco = precos.get(produto);

            System.out.println(produto + " - Quantidade: " + quantidade + " - Preço Unitário: " + preco);

        }
    }
}
