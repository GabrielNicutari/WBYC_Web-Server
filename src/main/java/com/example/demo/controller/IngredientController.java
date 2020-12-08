package com.example.demo.controller;

import com.example.demo.model.Ingredient;
import com.example.demo.service.IngredientService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@CrossOrigin(origins = {
        "http://localhost:8081",
        "http://localhost:3000",
        "https://wbyc-web-client.herokuapp.com"
})
@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    // fetch
    @GetMapping({"/", ""})
    public ResponseEntity<Map<String, Object>> getPageOfRecipes(
            @RequestParam(required = false) String key,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        return ingredientService.getPageOfRecipes(key, page, size, sort);
    }

    // create
    @PostMapping("/create")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.createIngredient(ingredient);
    }

    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable("id") int id, @RequestBody Ingredient ingredient) {
        return ingredientService.updateIngredient(id, ingredient);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteIngredient(@PathVariable("id") int id) {
        return ingredientService.deleteIngredient(id);
    }
}