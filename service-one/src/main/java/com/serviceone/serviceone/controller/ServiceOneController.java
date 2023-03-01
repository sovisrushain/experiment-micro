package com.serviceone.serviceone.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/so")
public class ServiceOneController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping(value = "/{id}")
    //@Retry(name = "so-api", fallbackMethod = "fallbackResponse")
    @CircuitBreaker(name = "so-api", fallbackMethod = "fallbackResponse")
    public String greet(@PathVariable String id) {
        String show = webClientBuilder.build()
                .get()
                .uri("http://service-two/st/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return "My favourite anime is: " + show;
    }

    public String fallbackResponse(Exception exception) {
        return "Ops! It seems server is down. Please wait and try again.";
    }
}
