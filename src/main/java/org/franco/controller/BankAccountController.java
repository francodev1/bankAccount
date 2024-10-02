package org.franco.controller;

import org.franco.entities.BankAccount;
import org.franco.service.BankAccountService;

import java.util.Scanner;

public class BankAccountController {
    private BankAccountService bankAccountService;
    private Scanner sc;

    public BankAccountController(BankAccountService bankAccountService, Scanner sc) {
        this.bankAccountService = bankAccountService;
        this.sc = sc;
    }

    public void start() {
        int openAccount = 0;

        System.out.println("Bem Vindo ao Banco Franco");

        while (true) {
            System.out.println("Entrar ou Criar Conta? (1 - Entrar, 2 - Criar)");
            openAccount = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (openAccount == 2) {
                createAccount();
                openAccount = 1; // After creating, go to login
            }

            if (openAccount == 1) {
                if (login()) {
                    break;
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void createAccount() {
        System.out.println("Digite o nome do titular da conta:");
        String name = sc.nextLine();
        System.out.println("Digite o número da conta:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        BankAccount bankAccount = new BankAccount(id, name, 0.0);
        bankAccountService.addAccount(bankAccount);

        System.out.println("Voce quer fazer um depósito inicial? (s/n)");
        char response = sc.next().charAt(0);
        if (response == 's') {
            System.out.println("Digite o valor do depósito inicial:");
            double amount = sc.nextDouble();
            bankAccount.deposit(amount);
        }

        System.out.println("Conta criada com sucesso!");
        System.out.println("Dados da conta:");
        System.out.println(bankAccount.accountCreated());
    }

    private boolean login() {
        System.out.println("Digite o número da conta:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        BankAccount bankAccount = bankAccountService.getAccount(id);
        if (bankAccount != null) {
            System.out.println("Dados da conta:");
            System.out.println(bankAccount.accountCreated());
            performOperations(bankAccount);
            return true;
        } else {
            System.out.println("Conta não encontrada. Tente novamente.");
            return false;
        }
    }

    private void performOperations(BankAccount bankAccount) {
        int actions;
        System.out.println("Deseja fazer alguma operação? (1 - Deposito, 2 - Saque, 3 - Sair)");
        actions = sc.nextInt();
        switch (actions) {
            case 1:
                System.out.println("Digite o valor do depósito:");
                double amount = sc.nextDouble();
                bankAccount.deposit(amount);
                break;
            case 2:
                System.out.println("Digite o valor do saque:");
                amount = sc.nextDouble();
                bankAccount.withdraw(amount);
                break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }

        System.out.println(bankAccount.accountUpdated());

        System.out.println("Obrigado por usar nossos serviços! Banco Franco Agradece!");
    }
}