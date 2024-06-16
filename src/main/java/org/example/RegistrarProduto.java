package org.example;

import java.util.HashMap;

public class RegistrarProduto {
    public void adicionarProduto(String produto, double preco, int quantidade, HashMap<String, Integer>carrinho){
        if (carrinho.containsKey(produto)){
            carrinho.put(produto, carrinho.get(produto) + quantidade);
        }else {
            carrinho.put(produto, quantidade);
        }
    }
    public void removerProduto(String produto, double preco, int quantidade, HashMap<String, Integer>carrinho){
        if(carrinho.containsKey(produto)){
            int quantidadeAtual = carrinho.get(produto);
            if( quantidadeAtual <= quantidade){
                carrinho.remove(produto);
            }else {
                carrinho.put(produto, quantidadeAtual - quantidade);
            }
        }else {
            System.out.print("O produto nao esta no carrinho");
        }
    }
}
