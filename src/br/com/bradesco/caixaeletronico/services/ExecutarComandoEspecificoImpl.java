package br.com.bradesco.caixaeletronico.services;

import br.com.bradesco.caixaeletronico.repository.MemoriaContaRepository;

import java.util.Scanner;

public class ExecutarComandoEspecificoImpl implements br.com.bradesco.caixaeletronico.services.ExecutarComandoEspecifico {

    private final br.com.bradesco.caixaeletronico.services.Deposito deposito;
    private final SaqueImpl saque;
    private final br.com.bradesco.caixaeletronico.services.AbrirConta abrirConta;


    public ExecutarComandoEspecificoImpl() {
        MemoriaContaRepository repository = new MemoriaContaRepository();
        this.deposito = new br.com.bradesco.caixaeletronico.services.DepositoImpl(repository);
        this.saque = new SaqueImpl(repository);
        this.abrirConta = new br.com.bradesco.caixaeletronico.services.AbrirContaImpl(repository);

    }

    @Override
    public boolean execute(int comando) {
        boolean resultado = true;
        Scanner entrada = new Scanner(System.in);

        if (comando == 0) {
            System.out.println("Finalizado!");
            resultado = false;

        } else if (comando == 1) {
            this.abrirConta.execute();

        } else if (comando == 2) {
            System.out.println("Digite o número de sua conta: ");
            int numeroDaConta = entrada.nextInt();
            System.out.println("Digite o valor do deposito: ");
            double valorASerDepositado = entrada.nextInt();
            this.deposito.execute(valorASerDepositado, numeroDaConta);

        } else if (comando == 3) {
            System.out.println("Digite o número de sua conta: ");
            int numeroDaConta = entrada.nextInt();
            System.out.println("Digite o valor do saque: ");
            double valorASerSacado = entrada.nextInt();
            this.saque.execute(valorASerSacado, numeroDaConta);

        }  else {
            System.out.println("Erro");
        }
        return resultado;
    }

}