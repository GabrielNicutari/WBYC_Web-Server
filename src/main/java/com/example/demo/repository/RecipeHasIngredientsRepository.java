package com.example.demo.repository;

import com.example.demo.model.RecipeHasIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeHasIngredientsRepository extends JpaRepository<RecipeHasIngredients, Integer> {
}
