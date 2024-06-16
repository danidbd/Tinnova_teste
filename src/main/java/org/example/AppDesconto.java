package org.example;

public class AppDesconto {

    public double aplicarDesconto(double total, double desconto) {

        double descontoDecimal = desconto / 100.0;

        return total - (total * descontoDecimal);
    }
}
