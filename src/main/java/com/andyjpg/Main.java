package com.andyjpg;

import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int principal = (int)readNumber(
                "Principal ($1K - $1M): ",
                1_000,
                1_000_000
        );
        float annualInterestRate = (float)readNumber(
                "Annual Interest Rate: ",
                0,
                30
        );
        byte period = (byte)readNumber(
                "Period (Years): ",
                1,
                30
        );

        double mortgageRate = getMortgageRate(principal, annualInterestRate, period);

        String printMortgageRate = NumberFormat.getCurrencyInstance().format(mortgageRate);
        System.out.println("Mortgage Rate: " + printMortgageRate);
    }

    public static double readNumber(String prompt, double minValue, double maxValue) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print(prompt);
            double number = scan.nextDouble();
            if(number >= minValue && number <= maxValue) {
                return number;
            }
            System.out.println("Enter a value between " + minValue + " and " + maxValue);
        }

    }

    public static double getMortgageRate(int principal, float annualInterestRate, byte period) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = (annualInterestRate / MONTHS_IN_YEAR) / PERCENT;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
    }
}