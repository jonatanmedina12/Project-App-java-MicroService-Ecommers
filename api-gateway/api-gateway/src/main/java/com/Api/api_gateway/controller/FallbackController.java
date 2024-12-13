package com.Api.api_gateway.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/products")
    public ResponseEntity<String> productFallback() {
        return ResponseEntity
                .ok("Product Service is not available at the moment. Please try again later.");
    }

    @GetMapping("/orders")
    public ResponseEntity<String> orderFallback() {
        return ResponseEntity
                .ok("Order Service is not available at the moment. Please try again later.");
    }

    @GetMapping("/users")
    public ResponseEntity<String> userFallback() {
        return ResponseEntity
                .ok("User Service is not available at the moment. Please try again later.");
    }
}
