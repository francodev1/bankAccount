package org.franco;

import org.franco.controller.BankAccountController;
import org.franco.service.BankAccountService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccountService bankAccountService = new BankAccountService();
        BankAccountController controller = new BankAccountController(bankAccountService, sc);

        controller.start();

        sc.close();
    }
}