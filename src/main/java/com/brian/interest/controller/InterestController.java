package com.brian.interest.controller;

import com.brian.interest.dto.InterestRequest;
import com.brian.interest.dto.InterestResponse;
import com.brian.interest.service.InterestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The REST Controller. 
 * This acts as the "Traffic Cop", taking HTTP requests and routing them to your Service.
 * It is equivalent to an Express Router or an ASP.NET API Controller.
 */
@RestController
@RequestMapping("/api/interest")
public class InterestController {

    private final InterestService interestService;

    // Dependency Injection: Spring automatically provides the InterestService
    // because we marked it with @Service.
    public InterestController(InterestService interestService) {
        this.interestService = interestService;
    }

    /**
     * A simple GET endpoint to verify the API is running if someone visits it in a browser.
     */
    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("🚀 Java Interest Engine API is running! Send a POST request to /api/interest/calculate to use it.");
    }

    /**
     * Endpoint to calculate interest.
     * Expects a POST request with JSON body.
     */
    @PostMapping("/calculate")
    public ResponseEntity<?> calculateInterest(@RequestBody InterestRequest request) {
        try {
            // Convert percentage (e.g. 5.0) to decimal (0.05)
            double rateDecimal = request.getRate() / 100.0;

            double simple = interestService.calculateSimpleInterest(
                    request.getPrincipal(), 
                    rateDecimal, 
                    request.getYears()
            );

            double compound = interestService.calculateCompoundInterest(
                    request.getPrincipal(), 
                    rateDecimal, 
                    request.getYears()
            );

            InterestResponse response = new InterestResponse(
                    request.getPrincipal(), 
                    simple, 
                    compound
            );

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            // If the service throws an error (like negative values), 
            // return a 400 Bad Request with the message.
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // Generic fallback
            return ResponseEntity.internalServerError().body("An unexpected error occurred.");
        }
    }
}
