package com.Api.api_gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Ruta para el servicio de productos
                .route("product-service", r -> r
                        .path("/api/products/**")
                        .filters(f -> f
                                .rewritePath("/api/products/(?<segment>.*)", "/${segment}")
                                .addRequestHeader("X-Gateway-Request", "true")
                                .circuitBreaker(config -> config
                                        .setName("productServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallback/products")))
                        .uri("lb://product-service"))

                // Ruta para el servicio de órdenes
                .route("order-service", r -> r
                        .path("/api/orders/**")
                        .filters(f -> f
                                .rewritePath("/api/orders/(?<segment>.*)", "/${segment}")
                                .addRequestHeader("X-Gateway-Request", "true")
                                .circuitBreaker(config -> config
                                        .setName("orderServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallback/orders")))
                        .uri("lb://order-service"))

                // Ruta para el servicio de usuarios
                .route("user-service", r -> r
                        .path("/api/users/**")
                        .filters(f -> f
                                .rewritePath("/api/users/(?<segment>.*)", "/${segment}")
                                .addRequestHeader("X-Gateway-Request", "true")
                                .circuitBreaker(config -> config
                                        .setName("userServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallback/users")))
                        .uri("lb://user-service"))
                .build();
    }

}
