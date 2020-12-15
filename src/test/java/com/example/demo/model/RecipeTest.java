package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    Collection<RecipeHasIngredients> recipeHasIngredients = new ArrayList<>();

    @BeforeEach
    void fillCollection() {
        recipeHasIngredients.add(new RecipeHasIngredients(1));
        recipeHasIngredients.add(new RecipeHasIngredients(4));
    }
    
    private final Recipe recipe = new Recipe(0, "pasta", "spaghetti", "Dr. Oetker", 10, 25, 4, "cook", "icon", "image", 250, recipeHasIngredients);

    @Test
    void getId() {
        assertEquals(0, recipe.getId());
    }

    @Test
    void setId() {
        recipe.setId(52);
        assertEquals(52, recipe.getId());
    }

    @Test
    void getName() {
        assertEquals("pasta", recipe.getName());
    }

    @Test
    void setName() {
        recipe.setName("fries");
        assertEquals("fries", recipe.getName());
    }

    @Test
    void getDescription() {
        assertEquals("spaghetti", recipe.getDescription());
    }

    @Test
    void setDescription() {
        recipe.setDescription("crisps");
        assertEquals("crisps", recipe.getDescription());
    }

    @Test
    void getAuthor() {
        assertEquals("Dr. Oetker", recipe.getAuthor());
    }

    @Test
    void setAuthor() {
        recipe.setAuthor("MC");
        assertEquals("MC", recipe.getAuthor());
    }

    @Test
    void getPrepTime() {
        assertEquals(10, recipe.getPrepTime());
    }

    @Test
    void setPrepTime() {
        recipe.setPrepTime(15);
        assertEquals(15, recipe.getPrepTime());
    }

    @Test
    void getCookTime() {
        assertEquals(25, recipe.getCookTime());
    }

    @Test
    void setCookTime() {
        recipe.setCookTime(10);
        assertEquals(10, recipe.getCookTime());
    }

    @Test
    void getPortions() {
        assertEquals(4, recipe.getPortions());
    }

    @Test
    void setPortions() {
        recipe.setPortions(8);
        assertEquals(8, recipe.getPortions());
    }

    @Test
    void getInstructions() {
        assertEquals("cook", recipe.getInstructions());
    }

    @Test
    void setInstructions() {
        recipe.setInstructions("eat");
        assertEquals("eat", recipe.getInstructions());
    }

    @Test
    void getIconSrc() {
        assertEquals("icon", recipe.getIconSrc());
    }

    @Test
    void setIconSrc() {
        recipe.setIconSrc("icon2");
        assertEquals("icon2", recipe.getIconSrc());
    }

    @Test
    void getImageSrc() {
        assertEquals("image", recipe.getImageSrc());
    }

    @Test
    void setImageSrc() {
        recipe.setImageSrc("image2");
        assertEquals("image2", recipe.getImageSrc());
    }
    
    @Test
    void getRecipeHasIngredientsById() {
        Collection<RecipeHasIngredients> list = new ArrayList<>();
        list.add(new RecipeHasIngredients(1));
        list.add(new RecipeHasIngredients(4));
        assertEquals(list, recipe.getRecipeHasIngredientsById());
    }

    @Test
    void setRecipeHasIngredientsById() {
        Collection<RecipeHasIngredients> list = new ArrayList<>();
        list.add(new RecipeHasIngredients(2));
        list.add(new RecipeHasIngredients(5));
        list.add(new RecipeHasIngredients(45));

        recipe.setRecipeHasIngredientsById(list);
        assertEquals(list, recipe.getRecipeHasIngredientsById());
    }

    @Test
    void testEquals() {
        assertNotEquals(new Recipe(), recipe);    //this one compares one with values inside
        assertEquals(new Recipe(), new Recipe());
    }

    @Test
    void testHashCode() {
//        final int PRIME = 59;
//        int result = 1;
//        result = result * PRIME + recipe.getId();
//        final Object $name = recipe.getName();
//        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
//        final Object $description = recipe.getDescription();
//        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
//        final Object $author = recipe.getAuthor();
//        result = result * PRIME + ($author == null ? 43 : $author.hashCode());
//        result = result * PRIME + recipe.getPrepTime();
//        result = result * PRIME + recipe.getCookTime();
//        result = result * PRIME + recipe.getPortions();
//        final Object $instructions = recipe.getInstructions();
//        result = result * PRIME + ($instructions == null ? 43 : $instructions.hashCode());
//        final Object $iconSrc = recipe.getIconSrc();
//        result = result * PRIME + ($iconSrc == null ? 43 : $iconSrc.hashCode());
//        final Object $imageSrc = recipe.getImageSrc();
//        result = result * PRIME + ($imageSrc == null ? 43 : $imageSrc.hashCode());
//        final Object $recipeHasIngredientsById = recipe.getRecipeHasIngredientsById();
//        result = result * PRIME + ($recipeHasIngredientsById == null ? 43 : $recipeHasIngredientsById.hashCode());
//
//        assertEquals(result, recipe.hashCode());
    }
}