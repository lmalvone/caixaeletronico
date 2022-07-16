package br.com.bradesco.caixaeletronico.services;

import br.com.bradesco.caixaeletronico.model.Conta;
import br.com.bradesco.caixaeletronico.repository.MemoriaContaRepository;

public class AbrirContaImpl implements br.com.bradesco.caixaeletronico.services.AbrirConta {

    private final MemoriaContaRepository repository;

    public AbrirContaImpl(MemoriaContaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Conta execute() {
        Conta conta;
        conta = new Conta();
        repository.adiciona(conta);
        System.out.printf(" Número da conta: '%d' , Saldo Atual: R$ %.2f. %n", conta.getNumeroDaConta(), conta.getSaldo());
        return conta;
    }

}