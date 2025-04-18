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
        int principal;
        double annualInterestRate;
        int period;
        while(true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scan.nextInt();
            if(principal < 1_000 || principal > 1_000_000) {
                System.out.println("Enter a number between 1,000 and 1,000,000.");
            } else break;
        }
        while(true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scan.nextDouble();
            if(annualInterestRate <= 0 || annualInterestRate > 30) {
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
            } else break;
        }
        while(true) {
            System.out.print("Period (Years): ");
            period = scan.nextInt();
            if(period < 1 || period > 30) {
                System.out.println("Enter a value between 1 and 30.");
            } else break;
        }

        double monthlyInterestRate = (annualInterestRate / MONTHS_IN_YEAR) / PERCENT;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgageRate = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));

        String printMortgageRate = NumberFormat.getCurrencyInstance().format(mortgageRate);
        System.out.println("Mortgage Rate: " + printMortgageRate);
    }
}