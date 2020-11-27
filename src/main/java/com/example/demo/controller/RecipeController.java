package com.example.demo.controller;

import com.example.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    // fetch

    // create
    // update
    // delete

}
