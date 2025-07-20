package com.example.order_service.client;

import com.example.order_service.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserClient {
    private final WebClient webClient;

    public UserClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    // Get a user by ID from user-service
    public User getUserById(Long userId) {
        return webClient.get()
                .uri("/users/{id}", userId)
                .retrieve()
                .bodyToMono(User.class)
                .block(); // blocking for simplicity, in production consider reactive approach
    }
}
