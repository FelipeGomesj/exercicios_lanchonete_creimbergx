package com.exercicio.model;

public class Lanche {
    private int codigo;
    private String especificacao;
    private double preco;

    public Lanche (int codigo, String especificacao,  double preco){
        this.codigo = codigo;
        this.especificacao = especificacao;
        this.preco = preco;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
