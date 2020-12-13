package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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
    private Collection<RecipeHasIngredients> recipeHasIngredientsById;

    public Recipe(int id) {
        this.id = id;
    }

    public Recipe(String name, String description, String author,
                  int prepTime, int cookTime, int portions,
                  String instructions, String iconSrc, String imageSrc,
                  Collection<RecipeHasIngredients> recipeHasIngredientsById) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.portions = portions;
        this.instructions = instructions;
        this.iconSrc = iconSrc;
        this.imageSrc = imageSrc;
        this.recipeHasIngredientsById = recipeHasIngredientsById;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
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

    @OneToMany(mappedBy = "recipesByRecipeId")
    public Collection<RecipeHasIngredients> getRecipeHasIngredientsById() {
        return recipeHasIngredientsById;
    }

    public void setRecipeHasIngredientsById(Collection<RecipeHasIngredients> recipeHasIngredientsById) {
        this.recipeHasIngredientsById = recipeHasIngredientsById;
    }
}
