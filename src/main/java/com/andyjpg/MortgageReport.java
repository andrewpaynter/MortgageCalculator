package com.andyjpg;

import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currency;
    private final MortgageCalculator calculator;

    MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgageInformation() {
        printMonthlyPayments(calculator);
        printPaymentSchedule(calculator);
    }

    private void printMonthlyPayments(MortgageCalculator calculator) {
        Console.printHeader("mortgage");
        double monthlyPayment = calculator.getMortgageRate();
        System.out.println("Monthly Payments: " + currency.format(monthlyPayment));
    }

    private void printPaymentSchedule(MortgageCalculator calculator) {
        Console.printHeader("payment schedule");
        for (double payment : calculator.getPaymentSchedule()) {
            System.out.println(currency.format(payment));
        }
    }
}
