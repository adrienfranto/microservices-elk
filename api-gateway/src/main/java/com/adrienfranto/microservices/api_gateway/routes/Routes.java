package com.adrienfranto.microservices.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {

    @Bean
    public RouteLocator etudiantServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("etudiant_service", r -> r
                        .path("/api/etudiants/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("etudiantServiceCircuitBreaker")
                                .setFallbackUri("forward:/fallback/etudiant")))
                        .uri("http://192.168.88.13:8080"))
                .build();
    }

    @Bean
    public RouteLocator etudiantServiceSwaggerRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("etudiant-service-swagger", r -> r
                        .path("/aggregate/etudiant-service/v3/api-docs")
                        .filters(f -> f.rewritePath(
                                "/aggregate/etudiant-service/v3/api-docs",
                                "/v3/api-docs"))
                        .uri("http://192.168.88.13:8080"))
                .build();
    }

    @Bean
    public RouteLocator travailServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("travail_service", r -> r
                        .path("/api/travail/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("travailServiceCircuitBreaker")
                                .setFallbackUri("forward:/fallback/travail")))
                        .uri("http://192.168.88.13:8081"))
                .build();
    }

    @Bean
    public RouteLocator travailServiceSwaggerRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("travail-service-swagger", r -> r
                        .path("/aggregate/travail-service/v3/api-docs")
                        .filters(f -> f.rewritePath(
                                "/aggregate/travail-service/v3/api-docs",
                                "/v3/api-docs"))
                        .uri("http://192.168.88.13:8081"))
                .build();
    }

    @Bean
    public RouteLocator groupeServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("groupe_service", r -> r
                        .path("/api/groupes/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("groupeServiceCircuitBreaker")
                                .setFallbackUri("forward:/fallback/groupe")))
                        .uri("http://192.168.88.13:8082"))
                .build();
    }


    @Bean
    public RouteLocator groupeServiceSwaggerRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("groupe-service-swagger", r -> r
                        .path("/aggregate/groupe-service/v3/api-docs")
                        .filters(f -> f.rewritePath(
                                "/aggregate/groupe-service/v3/api-docs",
                                "/v3/api-docs"))
                        .uri("http://192.168.88.13:8082"))
                .build();
    }
}
