package com.andyjpg;

import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int homeValue = (int) readNumber(
                "Home Value ($1K - $1M): $",
                1_000,
                1_000_000
        );
        int downPayment = (int) readNumber(
                "Down Payment Amount: $",
                0,
                homeValue
        );
        float annualInterestRate = (float) readNumber(
                "Annual Interest Rate (%): ",
                0,
                30
        );
        byte period = (byte) readNumber(
                "Period (Years): ",
                1,
                30
        );

        int principal = homeValue - downPayment;
        float monthlyInterestRate = (annualInterestRate / MONTHS_IN_YEAR) / PERCENT;
        int numberOfTotalPayments = period * MONTHS_IN_YEAR;

        printMonthlyPayments(principal, monthlyInterestRate, numberOfTotalPayments);
        printPaymentSchedule(numberOfTotalPayments, principal, monthlyInterestRate);
    }

    private static void printMonthlyPayments(int principal, float monthlyInterestRate, int numberOfTotalPayments) {
        printHeader("mortgage");
        double monthlyPayment = getMortgageRate(principal, monthlyInterestRate, numberOfTotalPayments);
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
    }

    private static void printPaymentSchedule(int numberOfTotalPayments, int principal, float monthlyInterestRate) {
        printHeader("payment schedule");
        for (int numberOfPayments = 0; numberOfPayments <= numberOfTotalPayments; numberOfPayments++) {
            double remainingBalance = getLoanBalance(principal,
                                                     monthlyInterestRate,
                                                     numberOfTotalPayments,
                                                     numberOfPayments);
            System.out.println(NumberFormat.getCurrencyInstance().format(remainingBalance));
        }
    }

    public static void printHeader(String header) {
        System.out.println();
        System.out.println(header.toUpperCase());
        for (int i = 0; i < header.length(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public static double readNumber(String prompt, double minValue, double maxValue) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            double number = scan.nextDouble();
            if (number >= minValue && number <= maxValue)
                return number;
            System.out.println("Enter a value between " + minValue + " and " + maxValue);
        }

    }

    public static double getMortgageRate(int principal, float monthlyInterestRate, int numberOfPayments) {
        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
    }

    public static double getLoanBalance(
            int principal,
            float monthlyInterestRate,
            int totalNumberOfPayments,
            int numberOfPayments) {
        return principal
                * (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - Math.pow(1 + monthlyInterestRate,
                                                                                       numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - 1);
    }
}