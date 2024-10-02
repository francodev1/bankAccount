package org.franco.entities;


public class BankAccount {
    protected final int id;
    private String name;
    private double balance;

    public BankAccount(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount + 5.0;
    }

    public String accountCreated(){
        return "Conta:" + getId() + ", Nome:" + getName() + ", Saldo: R$ " + String.format("%.2f", getBalance());
    }

    public String accountUpdated(){
        return "Conta:" + getId() + ", Nome:" + getName() + ", Saldo: R$ " + String.format("%.2f", getBalance());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
