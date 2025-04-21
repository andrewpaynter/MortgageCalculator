package com.andyjpg;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int homeValue = (int) Console.readNumber(
                "Home Value ($1K - $1M): $",
                1_000,
                1_000_000
        );
        int downPayment = (int) Console.readNumber(
                "Down Payment Amount: $",
                0,
                homeValue
        );
        float annualInterestRate = (float) Console.readNumber(
                "Annual Interest Rate (%): ",
                0,
                30
        );
        byte period = (byte) Console.readNumber(
                "Period (Years): ",
                1,
                30
        );

        var calculator = new MortgageCalculator(homeValue, downPayment, annualInterestRate, period);

        var report = new MortgageReport(calculator);
        report.printMortgageInformation();
    }
}