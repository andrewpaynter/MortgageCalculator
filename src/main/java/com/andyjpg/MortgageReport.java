package com.andyjpg;

import java.text.NumberFormat;

public class MortgageReport {
    private final MortgageCalculator calculator;

    MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortgageInformation() {
        printMonthlyPayments(calculator);
        printPaymentSchedule(calculator);
    }

    private void printMonthlyPayments(MortgageCalculator calculator) {
        Console.printHeader("mortgage");
        double monthlyPayment = calculator.getMortgageRate();
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
    }

    private void printPaymentSchedule(MortgageCalculator calculator) {
        Console.printHeader("payment schedule");
        var numberOfTotalPayments = calculator.getNumberOfTotalPayments();
        for (int numberOfPayments = 0; numberOfPayments <= numberOfTotalPayments; numberOfPayments++) {
            double remainingBalance = calculator.getLoanBalance(numberOfPayments);
            System.out.println(NumberFormat.getCurrencyInstance().format(remainingBalance));
        }
    }
}
