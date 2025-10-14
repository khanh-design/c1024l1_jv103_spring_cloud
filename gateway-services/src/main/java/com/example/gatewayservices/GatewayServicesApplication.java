package com.example.gatewayservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServicesApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-route", r -> r.path("/user/**")
                        .filters(f -> f.stripPrefix(1)
                                .circuitBreaker(c -> c.setName("CircuitBreaker")
                                        .getFallbackUri())) // cấu hình quá tải
                        .uri("lb://account-services"))
                .route("report-route", r -> r.path("/report/**")
                        .filters(f -> f.stripPrefix(1)
                                .circuitBreaker(c -> c.setName("CircuitBreaker")
                                        .getFallbackUri()))
                        .uri("lb://statistic-services"))
                .route("notificaion-route", r -> r.path("/notification/**")
                        .filters(f -> f.stripPrefix(1)
                                .circuitBreaker(c -> c.setName("CircuitBreaker")
                                        .getFallbackUri()))
                        .uri("lb://notification-services"))

                //swagger-ui
                .route("openai", r -> r.path("/v3/api-doc/**")
                        .filters(f -> f.rewritePath("/v3/api-doc/(?<service>.*)","/${service}/v3/api-docs"))
                        .uri("lb:/gateway-services"))
                .build();
    }
}
