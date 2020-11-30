package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@JsonDeserialize
@Table(name = "recipe_has_ingredients", schema = "wbyc")
public class RecipeHasIngredients {
    private int id;
    private double unitSize;
    private Recipe recipesByRecipeId;
    private Ingredient ingredientsByIngredientId;

    public RecipeHasIngredients(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "unit_size", nullable = false, precision = 0)
    public double getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(double unitSize) {
        this.unitSize = unitSize;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", nullable = false)
    public Recipe getRecipesByRecipeId() {
        return recipesByRecipeId;
    }

    public void setRecipesByRecipeId(Recipe recipesByRecipeId) {
        this.recipesByRecipeId = recipesByRecipeId;
    }


    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id", nullable = false)
    public Ingredient getIngredientsByIngredientId() {
        return ingredientsByIngredientId;
    }

    public void setIngredientsByIngredientId(Ingredient ingredientsByIngredientId) {
        this.ingredientsByIngredientId = ingredientsByIngredientId;
    }
}
