package com.dafne.backend.Aula02_TemplateMethodPattern;

public abstract class Funcionario {

    private String nome, sobrenome, numeroConta;

    public Funcionario(String nome, String sobrenome, String numeroConta){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroConta = numeroConta;
    }

    public void pagamentoSalario(){
        double quantia;
        quantia = calcularSaldo();
        imprimirRecibo(quantia);
        depositar(quantia);
    }

    public abstract double calcularSaldo();
    public abstract void imprimirRecibo(double quantia);
    public abstract void depositar(double quantia);


}
