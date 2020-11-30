package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeHasIngredientsTest {

    private final RecipeHasIngredients recipeHasIngredients =  new RecipeHasIngredients(0, 3.7, new Recipe(2), new Ingredient(2));

    @Test
    void getId() {
        assertEquals(0, recipeHasIngredients.getId());
    }

    @Test
    void setId() {
        recipeHasIngredients.setId(24);
        assertEquals(24, recipeHasIngredients.getId());
    }

    @Test
    void getUnitSize() {
        assertEquals(3.7, recipeHasIngredients.getUnitSize());
    }

    @Test
    void setUnitSize() {
        recipeHasIngredients.setUnitSize(5.0);
        assertEquals(5.0, recipeHasIngredients.getUnitSize());
    }

    @Test
    void getRecipeByRecipeId() {
        assertEquals(new Recipe(2), recipeHasIngredients.getRecipesByRecipeId());
    }

    @Test
    void setRecipeByRecipeId() {
        recipeHasIngredients.setRecipesByRecipeId(new Recipe(25));
        assertEquals(new Recipe(25), recipeHasIngredients.getRecipesByRecipeId());
    }

    @Test
    void getIngredientsByIngredientId() {
        assertEquals(new Ingredient(2), recipeHasIngredients.getIngredientsByIngredientId());
    }

    @Test
    void setIngredientsByIngredientId() {
        recipeHasIngredients.setIngredientsByIngredientId(new Ingredient(25));
        assertEquals(new Ingredient(25), recipeHasIngredients.getIngredientsByIngredientId());
    }

    @Test
    void testEquals() {
        assertNotEquals(new RecipeHasIngredients(), recipeHasIngredients);    //this one compares one with values inside
        assertEquals(new RecipeHasIngredients(), new RecipeHasIngredients());
    }

    @Test
    void testHashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + recipeHasIngredients.getId();
        final long $unitSize = Double.doubleToLongBits(recipeHasIngredients.getUnitSize());
        result = result * PRIME + (int) ($unitSize >>> 32 ^ $unitSize);
        final Object $recipesByRecipeId = recipeHasIngredients.getRecipesByRecipeId();
        result = result * PRIME + ($recipesByRecipeId == null ? 43 : $recipesByRecipeId.hashCode());
        final Object $ingredientsByIngredientId = recipeHasIngredients.getIngredientsByIngredientId();
        result = result * PRIME + ($ingredientsByIngredientId == null ? 43 : $ingredientsByIngredientId.hashCode());

        assertEquals(result, recipeHasIngredients.hashCode());
    }
}