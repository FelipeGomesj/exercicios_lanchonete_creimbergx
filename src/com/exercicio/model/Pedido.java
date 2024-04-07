package com.exercicio.model;

public class Pedido {
    private Lanche lanche;
    private int quantidadeDeLanches;
    private double valor;

    //constructor
    public Pedido() {}


    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public int getQuantidadeDeLanches() {
        return quantidadeDeLanches;
    }

    public void setQuantidadeDeLanches(int quantidadeDeLanches) {
        this.quantidadeDeLanches = quantidadeDeLanches;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
