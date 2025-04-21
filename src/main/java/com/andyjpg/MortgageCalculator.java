package com.andyjpg;

public class MortgageCalculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    private int homeValue = 0;
    private int downPayment;
    private float annualInterestRate;
    private byte period;


    public MortgageCalculator(int homeValue, int downPayment, float annualInterestRate, byte period) {
        setHomeValue(homeValue);
        setDownPayment(downPayment);
        setAnnualInterestRate(annualInterestRate);
        setPeriod(period);
    }

    private void setHomeValue(int homeValue) {
        if (homeValue > 1_000_000 || homeValue < 1_000) {
            throw new IllegalArgumentException("homeValue must be between 1_000 and 1_000_000");
        }
        this.homeValue = homeValue;
    }

    private void setDownPayment(int downPayment) {
        if (downPayment < 0 || downPayment > homeValue) {
            throw new IllegalArgumentException("downPayment must be between 0 and homeValue");
        }
        this.downPayment = downPayment;
    }

    private void setAnnualInterestRate(float annualInterestRate) {
        if (annualInterestRate < 0 || annualInterestRate > 30) {
            throw new IllegalArgumentException("annualInterestRate must be between 0 and 30");
        }
        this.annualInterestRate = annualInterestRate;
    }

    private void setPeriod(byte period) {
        if (period < 0 || period > 30) {
            throw new IllegalArgumentException("period must be between 0 and 30");
        }
        this.period = period;
    }

    private int getPrincipal() {
        return homeValue - downPayment;
    }

    private float getMonthlyInterestRate() {
        return (annualInterestRate / MONTHS_IN_YEAR) / PERCENT;
    }

    public int getNumberOfTotalPayments() {
        return period * MONTHS_IN_YEAR;
    }

    public double getMortgageRate() {
        var monthlyInterestRate = getMonthlyInterestRate();
        var numberOfPayments = getNumberOfTotalPayments();
        return getPrincipal()
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
    }

    public double getLoanBalance(
            int numberOfPayments) {
        var principal = getPrincipal();
        var monthlyInterestRate = getMonthlyInterestRate();
        var totalNumberOfPayments = getNumberOfTotalPayments();
        return principal
                * (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - Math.pow(1 + monthlyInterestRate,
                                                                                       numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - 1);
    }
}
