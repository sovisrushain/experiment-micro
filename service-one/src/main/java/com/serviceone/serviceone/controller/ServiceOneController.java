package com.serviceone.serviceone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/service-one")
public class ServiceOneController {

    @GetMapping("/{id}")
    public String greet(@PathVariable String id) {
        return "My favourite show is " + id;
    }
}
