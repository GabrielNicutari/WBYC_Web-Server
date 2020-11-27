package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "recipe_has_ingredients", schema = "wbyc")
public class RecipeHasIngredients {
    private int id;
    private double unitSize;
    private Recipe recipesByRecipeId;
    private Ingredient ingredientsByIngredientId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeHasIngredients that = (RecipeHasIngredients) o;

        if (id != that.id) return false;
        if (Double.compare(that.unitSize, unitSize) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(unitSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
