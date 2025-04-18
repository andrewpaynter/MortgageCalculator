package com.andyjpg;

import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scan = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scan.nextInt();
        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = scan.nextDouble();
        System.out.print("Period (Years): ");
        int period = scan.nextInt();

        double monthlyInterestRate = (annualInterestRate / MONTHS_IN_YEAR) / PERCENT;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgageRate = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));

        String printMortgageRate = NumberFormat.getCurrencyInstance().format(mortgageRate);
        System.out.println("Mortgage Rate: " + printMortgageRate);
    }
}