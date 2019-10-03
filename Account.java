package com.company;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }
    public void setBalance(int value) {
        this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }
    @Override
    public String toString(){
        return ""+this.getBalance()+"";
    }
}
