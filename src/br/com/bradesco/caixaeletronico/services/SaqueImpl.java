package br.com.bradesco.caixaeletronico.services;

import br.com.bradesco.caixaeletronico.model.Conta;
import br.com.bradesco.caixaeletronico.repository.MemoriaContaRepository;

public class SaqueImpl implements Saque {
    private final MemoriaContaRepository repository;

    public SaqueImpl(MemoriaContaRepository repository) {
        this.repository = repository;
    }

    @Override
    public double execute(double valorASerSacado, int numeroDaConta) {
        Conta conta;
        conta = repository.findById(numeroDaConta);
        boolean saqueRealizado = conta.retirarSaldo(valorASerSacado);
        if (saqueRealizado) {
            System.out.printf("Saque realizado com sucesso! Saldo atual: R$ %.2f !%n", conta.getSaldo());
        }
        return valorASerSacado;
    }

}