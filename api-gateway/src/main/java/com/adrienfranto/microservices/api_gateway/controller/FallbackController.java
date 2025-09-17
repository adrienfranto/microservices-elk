package com.adrienfranto.microservices.api_gateway.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback/etudiant")
    public ResponseEntity<String> etudiantFallback() {
        return ResponseEntity.status(503).body("Etudiant service is unavailable. Please try again later.");
    }

    @GetMapping("/fallback/travail")
    public ResponseEntity<String> travailFallback() {
        return ResponseEntity.status(503).body("Travail service is unavailable. Please try again later.");
    }

    @GetMapping("/fallback/groupe")
    public ResponseEntity<String> groupeFallback() {
        return ResponseEntity.status(503).body("Groupe service is unavailable. Please try again later.");
    }
}