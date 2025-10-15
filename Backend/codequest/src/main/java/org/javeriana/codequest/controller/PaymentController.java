package org.javeriana.codequest.controller;

import java.util.Map;

import org.javeriana.codequest.service.StripeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.model.PaymentIntent;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final StripeService stripeService;

    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/create-payment-intent")
    public ResponseEntity<Map<String, String>> createPaymentIntent(@RequestBody Map<String, Object> body) {
        try {
            Long amount = Long.valueOf(String.valueOf(body.get("amount"))); // en centavos
            String currency = (String) body.getOrDefault("currency", "usd");
            PaymentIntent intent = stripeService.createPaymentIntent(amount, currency);
            return ResponseEntity.ok(Map.of("clientSecret", intent.getClientSecret()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        }
    }

}
