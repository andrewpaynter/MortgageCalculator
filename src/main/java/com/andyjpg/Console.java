package com.andyjpg;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt, double minValue, double maxValue) {
        while (true) {
            System.out.print(prompt);
            double number = scanner.nextDouble();
            if (number >= minValue && number <= maxValue)
                return number;
            System.out.println("Enter a value between " + minValue + " and " + maxValue);
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
}
