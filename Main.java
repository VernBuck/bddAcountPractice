package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("How much money do you have in your account?");
        Scanner scanAcc = new Scanner(System.in);
        int accountbalance = scanAcc.nextInt();
        Account[] accmade = createAccount(accountbalance);
        //System.out.println(Arrays.toString(accmade));
        select(accmade);
    }
    public static Account[] createAccount(int input) {
        Account value = new Account(input);
        Account[] acc = {value};
        System.out.println(Arrays.toString(acc));
        return acc;
    }

    public static void select(Account[] accmade) {
        System.out.println("What kind of transaction would you like to make?");
        System.out.println("type deposit, withdraw, or clone");
        Scanner scanString = new Scanner(System.in);
        String stringValue = scanString.nextLine();
        options(stringValue, accmade);
    }

    //for testing purposes only!
    public static String optionsTest(String inputS, Account[] a) {
        System.out.println(Arrays.toString(a));
        System.out.println(inputS);
        System.out.println("You successfully selected an option");
        return inputS;
    }

    public static void options(String inputS, Account[] a) {
        if (inputS.compareToIgnoreCase("deposit") == 0) {
            System.out.println("Redirecting to deposit");
            depositInbetween(a);
        } else if (inputS.compareToIgnoreCase("withdraw") == 0) {
            System.out.println("Redirecting to withdraw");
            withdrawInbetween(a);
        } else if (inputS.compareToIgnoreCase("clone") == 0) {
            System.out.println("Redirection to clone");
            clone(a);
        } else {
            System.out.println("The option you have chosen doesn't exist");
            select(a);
        }
    }
    public static void depositInbetween(Account[] bal) {
        System.out.println("How much money do you want to put into your account?");
        Scanner scanAcc = new Scanner(System.in);
        int valInt = scanAcc.nextInt();
        deposit(bal, valInt);
    }

    public static Account[] deposit(Account[] bal, int addval) {
        int curval = bal[0].getBalance();
        int total = curval + addval;
        bal[0] = new Account(total);
        System.out.println(Arrays.toString(bal));
        return bal;
    }

    public static void withdrawInbetween(Account[] bal) {
        System.out.println("How much money do you want to take out of your account?");
        Scanner scanAcc = new Scanner(System.in);
        int valInt = scanAcc.nextInt();
        withdraw(bal, valInt);
    }

    public static Account[] withdraw(Account[] bal, int subval) {
        int curval = bal[0].getBalance();
        if (subval > curval) {
            System.out.println("you cannot withdraw more than you have");
            withdrawInbetween(bal);
        } else {
            int total = curval - subval;
            bal[0] = new Account(total);
            System.out.println(Arrays.toString(bal));
            return bal;
        }
        return bal;
    }

    public static String clone(Account[] bal) {
        int curAcc = bal[0].getBalance();
        int temp = curAcc;
        int newAB = temp / 2;
        System.out.println("Clone cost processing");
        int newcurBAL = newAB - 1;
        if (newcurBAL < 0) {
            System.out.println("You do not have sufficient funds to clone");
            select(bal);
            return null;
        } else {
            bal[0] = new Account(newcurBAL);

            Account[] newAcc = createAccount(newAB);
            System.out.println(Arrays.toString(bal) +" " +Arrays.toString(newAcc));
            return Arrays.toString(bal) +" " +Arrays.toString(newAcc);
        }

    }
}
