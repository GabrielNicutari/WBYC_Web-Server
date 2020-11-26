package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "recipes", schema = "wbyc")
public class Recipe {
    private int id;
    private String name;
    private String description;
    private String author;
    private int prepTime;
    private int cookTime;
    private int portions;
    private String instructions;
    private String iconSrc;
    private String imageSrc;
    private Collection<OrderHasProducts> orderHasProductsById;
    private Collection<RecipeHasIngredients> recipeHasIngredientsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "author", nullable = false, length = 45)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "prep_time", nullable = false)
    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    @Basic
    @Column(name = "cook_time", nullable = false)
    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    @Basic
    @Column(name = "portions", nullable = false)
    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    @Basic
    @Column(name = "instructions", nullable = false, length = -1)
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Basic
    @Column(name = "icon_src", nullable = false, length = 256)
    public String getIconSrc() {
        return iconSrc;
    }

    public void setIconSrc(String iconSrc) {
        this.iconSrc = iconSrc;
    }

    @Basic
    @Column(name = "image_src", nullable = false, length = 256)
    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != recipe.id) return false;
        if (prepTime != recipe.prepTime) return false;
        if (cookTime != recipe.cookTime) return false;
        if (portions != recipe.portions) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        if (description != null ? !description.equals(recipe.description) : recipe.description != null) return false;
        if (author != null ? !author.equals(recipe.author) : recipe.author != null) return false;
        if (instructions != null ? !instructions.equals(recipe.instructions) : recipe.instructions != null)
            return false;
        if (iconSrc != null ? !iconSrc.equals(recipe.iconSrc) : recipe.iconSrc != null) return false;
        if (imageSrc != null ? !imageSrc.equals(recipe.imageSrc) : recipe.imageSrc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + prepTime;
        result = 31 * result + cookTime;
        result = 31 * result + portions;
        result = 31 * result + (instructions != null ? instructions.hashCode() : 0);
        result = 31 * result + (iconSrc != null ? iconSrc.hashCode() : 0);
        result = 31 * result + (imageSrc != null ? imageSrc.hashCode() : 0);
        return result;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "recipesByRecipeProductId")
    public Collection<OrderHasProducts> getOrderHasProductsById() {
        return orderHasProductsById;
    }

    public void setOrderHasProductsById(Collection<OrderHasProducts> orderHasProductsById) {
        this.orderHasProductsById = orderHasProductsById;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "recipesByRecipeId")
    public Collection<RecipeHasIngredients> getRecipeHasIngredientsById() {
        return recipeHasIngredientsById;
    }

    public void setRecipeHasIngredientsById(Collection<RecipeHasIngredients> recipeHasIngredientsById) {
        this.recipeHasIngredientsById = recipeHasIngredientsById;
    }
}
