package com.andyjpg;

import java.text.NumberFormat;

public class MortgageReport {
    public static void printMortgageInformation(Mortgage mortgage) {
        printMonthlyPayments(mortgage);
        printPaymentSchedule(mortgage);
    }

    private static void printMonthlyPayments(Mortgage mortgage) {
        Console.printHeader("mortgage");
        double monthlyPayment = mortgage.getMortgageRate();
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
    }

    private static void printPaymentSchedule(Mortgage mortgage) {
        Console.printHeader("payment schedule");
        var numberOfTotalPayments = mortgage.getNumberOfTotalPayments();
        for (int numberOfPayments = 0; numberOfPayments <= numberOfTotalPayments; numberOfPayments++) {
            double remainingBalance = mortgage.getLoanBalance(numberOfPayments);
            System.out.println(NumberFormat.getCurrencyInstance().format(remainingBalance));
        }
    }
}
