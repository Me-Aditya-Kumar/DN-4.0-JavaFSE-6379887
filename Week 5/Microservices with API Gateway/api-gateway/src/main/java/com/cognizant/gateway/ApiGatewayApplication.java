
package com.cognizant.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
    private static final Logger logger = Logger.getLogger(ApiGatewayApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public GlobalFilter logFilter() {
        return (exchange, chain) -> {
            logger.info("Incoming request: " + exchange.getRequest().getURI());
            return chain.filter(exchange);
        };
    }
}
