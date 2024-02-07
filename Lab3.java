// Programmers:  Carah and Bonita
// Course:  CS 212
// Due Date: Sunday, February 11, 2024
// Lab Assignment: Java ATM
// Problem Statement: You work at a bank and your current project is to design and implement a new interface for a new generation of ATMs.
// Data In: name, choice (d, w, b, e), deposit amount, withdrawal amount
// Data Out: balance, updated balance (based on withdraw/deposit)
// Credits: none

import java.util.Scanner;
import java.text.DecimalFormat;

class Lab3 {
    public static void main(String[] args) {
        // Call on classes
        Scanner input = new Scanner(System.in);
        DecimalFormat moneyFormat = new DecimalFormat("0.00");

        // Initialize variables
        double balance = 212.90;
        System.out.println("What is your name? ");
        String name = input.nextLine();

        // Welcome message
        System.out.println("---Welcome to the ATM, " + name + "---");

        // Opening statements + gives user options of choices
        menuOptions();

        String choice = input.nextLine().toLowerCase();

        // While user input isn't E,
        while (!choice.equals("e")) {
            // If input is B, print balance
            if (choice.equals("b")) {
                System.out.println("Your current balance is: $" + moneyFormat.format(balance));
            }
            // If input is D, call deposit method
            else if (choice.equals("d")) {
                balance = depositMethod(balance);
            }
            // If input is W, call withdraw method
            else if (choice.equals("w")) {
                balance = withdrawMethod(balance);
            }
            // Else, error message + option list
            else {
                System.out.println("Error. Invalid option choice. Please try again.");
                menuOptions();
            }
            // Provide user option list for next loop through
            menuOptions();
            choice = input.nextLine().toLowerCase();
        }
        // Exit message
        System.out.println("\nThank you for using the ATM. Have a nice day!");
    }

    static void menuOptions(){
        System.out.println("\nPlease select from the following options:");
        System.out.println("-".repeat(50));
        System.out.println("B - Balance\n\tThis will display your current balance");
        System.out.println("D - Deposit\n\tThis will allow you to deposit a provided amount into your balance");
        System.out.println("W - Withdraw\n\tThis will allow you to withdraw a provided amount from your balance");
        System.out.println("E - Exit");
        System.out.println("-".repeat(50));
    }

    static double withdrawMethod(double balance) {
        // Call on classes
        Scanner input = new Scanner(System.in);

        // Ask user how much they want to withdraw
        System.out.println("\nHow much money would you like to withdraw?");
        double withdraw = input.nextDouble();

        // While deposit is less than 0, error message + ask user for input again
        while (withdraw < 0) {
            System.out.println("Error. Invalid withdraw amount. Please try again.");
            System.out.println("How much money would you like to withdraw?");
            withdraw = input.nextDouble();
        }

        // Update balance (balance = balance - withdraw)
        balance -= withdraw;

        // Completion message
        System.out.println("Your balance has been updated.");

        // Returns withdraw back to main
        return balance;
    }

    static double depositMethod(double balance) {
        // Call on classes
        Scanner input = new Scanner(System.in);

        // Ask user how much they want to deposit
        System.out.println("\nHow much money would you like to deposit? ");
        double deposit = input.nextDouble();

        // While deposit is less than 0, error message + ask user for input again
        while (deposit < 0){
            System.out.println("Error. Invalid deposit amount. Please try again.");
            System.out.println("How much money would you like to deposit? ");
            deposit = input.nextDouble();
        }

        // Update balance (balance = balance + deposit)
        balance += deposit;

        // Completion message
        System.out.println("Your balance has been updated.");

        // Returns balance back to main
        return balance;
    }

}
