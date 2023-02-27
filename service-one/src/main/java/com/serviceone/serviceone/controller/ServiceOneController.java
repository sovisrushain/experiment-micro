package com.serviceone.serviceone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/service-one")
public class ServiceOneController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{id}")
    public String greet(@PathVariable String id) {
        String show = webClientBuilder.build()
                .get()
                .uri("http://service-two/api/service-two/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return "My favourite anime is: " + show;
    }
}
