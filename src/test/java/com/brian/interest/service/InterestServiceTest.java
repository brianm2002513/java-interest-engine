package com.brian.interest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for InterestService.
 * This proves the logic is bulletproof without needing to run the GUI.
 */
public class InterestServiceTest {

    private InterestService service;

    @BeforeEach
    void setUp() {
        service = new InterestService();
    }

    @Test
    @DisplayName("Test Simple Interest calculation with standard values")
    void testSimpleInterest() {
        double result = service.calculateSimpleInterest(1000, 0.05, 2);
        assertEquals(100.0, result, "1000 at 5% for 2 years should be 100 simple interest");
    }

    @Test
    @DisplayName("Test Compound Interest calculation with standard values")
    void testCompoundInterest() {
        double result = service.calculateCompoundInterest(1000, 0.05, 2);
        // A = 1000(1.05)^2 = 1102.5. I = 102.5
        assertEquals(102.5, result, 0.001, "1000 at 5% for 2 years should be 102.5 compound interest");
    }

    @Test
    @DisplayName("Test calculations with zero values")
    void testZeroValues() {
        assertEquals(0, service.calculateSimpleInterest(1000, 0, 5));
        assertEquals(0, service.calculateCompoundInterest(1000, 0, 5));
        assertEquals(0, service.calculateSimpleInterest(1000, 0.05, 0));
    }

    @Test
    @DisplayName("Ensure negative values throw exceptions")
    void testNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateSimpleInterest(-100, 0.05, 5);
        });
    }
}
