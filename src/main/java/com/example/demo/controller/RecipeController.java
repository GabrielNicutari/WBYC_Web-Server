package com.example.demo.controller;

import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {
        "http://localhost:8081",
        "http://localhost:3000",
        "https://wbyc-web-client.herokuapp.com"
})
@RestController
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    RecipeService recipeService;


    // fetch
    @GetMapping({"/", ""})
    public ResponseEntity<Map<String, Object>> getPageOfRecipes(
            @RequestParam(required = false) String key,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        return recipeService.getPageOfRecipes(key, page, size, sort);
    }


    // create
    @PostMapping("/create")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {

        return recipeService.createRecipe(recipe);
    }


    // update
    @PutMapping("update/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable ("id") int id, @RequestBody Recipe recipe) {

        return recipeService.updateRecipe(id, recipe);
    }


    // delete
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable("id") int id) {

        return recipeService.deleteRecipe(id);
    }
}
