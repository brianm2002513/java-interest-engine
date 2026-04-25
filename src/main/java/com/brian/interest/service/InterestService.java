package com.brian.interest.service;

/**
 * Service class responsible for interest calculations.
 * By separating this from the UI, we make the logic reusable and testable.
 */
public class InterestService {

    /**
     * Calculates Simple Interest.
     * Formula: I = P * r * t
     * 
     * @param principal The starting amount
     * @param rate The annual interest rate (as a decimal, e.g., 0.05 for 5%)
     * @param years The duration in years
     * @return The calculated simple interest
     */
    public double calculateSimpleInterest(double principal, double rate, int years) {
        if (principal < 0 || rate < 0 || years < 0) {
            throw new IllegalArgumentException("Parameters must be non-negative");
        }
        return principal * rate * years;
    }

    /**
     * Calculates Compound Interest (Interest earned only).
     * Formula: A = P(1 + r)^t, I = A - P
     * 
     * @param principal The starting amount
     * @param rate The annual interest rate (as a decimal)
     * @param years The duration in years
     * @return The calculated compound interest
     */
    public double calculateCompoundInterest(double principal, double rate, int years) {
        if (principal < 0 || rate < 0 || years < 0) {
            throw new IllegalArgumentException("Parameters must be non-negative");
        }
        double amount = principal * Math.pow(1 + rate, years);
        return amount - principal;
    }
}
