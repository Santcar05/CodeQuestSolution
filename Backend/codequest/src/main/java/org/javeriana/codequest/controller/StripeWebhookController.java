package org.javeriana.codequest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.PaymentIntent;
import com.stripe.net.Webhook;

@RestController
@RequestMapping("/api/payments")
public class StripeWebhookController {

    @Value("${stripe.webhook.secret}")
    private String webhookSecret;

    @PostMapping("/webhook")
    public ResponseEntity<String> handleStripeWebhook(@RequestBody String payload,
            @RequestHeader("Stripe-Signature") String sigHeader) {
        try {
            Event event = Webhook.constructEvent(payload, sigHeader, webhookSecret);

            // Manejar el evento según el tipo
            switch (event.getType()) {
                case "payment_intent.succeeded":
                    PaymentIntent intent = (PaymentIntent) event.getDataObjectDeserializer()
                            .getObject()
                            .orElse(null);
                    System.out.println("✅ Pago exitoso: " + intent.getId());
                    break;

                case "payment_intent.payment_failed":
                    System.out.println("❌ Pago fallido");
                    break;

                default:
                    System.out.println("Evento no manejado: " + event.getType());
                    break;
            }

            return ResponseEntity.ok("OK");
        } catch (SignatureVerificationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Firma inválida");
        }
    }
}
