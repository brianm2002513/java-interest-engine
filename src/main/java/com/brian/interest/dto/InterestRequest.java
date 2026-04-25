package com.brian.interest.dto;

/**
 * Data Transfer Object representing the incoming JSON request.
 * Spring will automatically map a JSON payload like:
 * {
 *   "principal": 1000,
 *   "rate": 5.0,
 *   "years": 2
 * }
 * directly into this Java object.
 */
public class InterestRequest {
    
    private double principal;
    // Rate is expected as a percentage (e.g., 5.0 for 5%)
    private double rate;
    private int years;

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
