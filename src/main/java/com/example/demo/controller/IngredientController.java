package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = {
        "http://localhost:8081",
        "http://localhost:3000",
        "https://wbyc-web-client.herokuapp.com"
})
@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @GetMapping({"/", ""})
    public ResponseEntity<Map<String, Object>> getPageOfRecipes(
            @RequestParam(required = false) String key,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        System.out.println("w/e");
        return null;
    }
}
