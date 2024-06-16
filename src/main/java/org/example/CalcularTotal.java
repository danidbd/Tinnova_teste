package org.example;

import java.util.HashMap;

public class CalcularTotal {
    public double calcularTotal(HashMap<String, Integer> carrinho, HashMap<String, Double> precos){

        double total = 0.0;

        for (String protudo : carrinho.keySet()){
            int quantidade = carrinho.get(protudo);
            double preco = precos.get(protudo);
            total += quantidade * preco;

        }
        return total;
    }
}
