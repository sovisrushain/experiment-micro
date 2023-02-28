package com.servicetwo.servicetwo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/st")
public class ServiceTwoController {

    @GetMapping("/{id}")
    public String getName(@PathVariable String id) {
        Map<String, String> map = new HashMap<>();
        map.put("100", "Naruto");
        map.put("101", "One Piece");
        map.put("102", "Death Note");
        map.put("103", "Berserk");
        map.put("104", "Chainsaw man");
        map.put("105", "Parasite");
        return map.get(id);
    }
}
