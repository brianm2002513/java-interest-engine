package com.brian.interest.dto;

/**
 * Data Transfer Object representing the outgoing JSON response.
 * Spring will automatically convert this object back into a JSON string
 * before sending it to the client.
 */
public class InterestResponse {
    
    private double principal;
    private double simpleInterest;
    private double compoundInterest;
    private double finalBalance;

    public InterestResponse(double principal, double simpleInterest, double compoundInterest) {
        this.principal = principal;
        this.simpleInterest = simpleInterest;
        this.compoundInterest = compoundInterest;
        this.finalBalance = principal + compoundInterest;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getSimpleInterest() {
        return simpleInterest;
    }

    public double getCompoundInterest() {
        return compoundInterest;
    }

    public double getFinalBalance() {
        return finalBalance;
    }
}
