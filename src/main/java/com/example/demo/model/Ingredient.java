package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ingredients", schema = "wbyc")
public class Ingredient {
    private int id;
    private String name;
    private double pricePerUnit;
    private MeasurementUnit measurementUnitByMeasurementUnitId;
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
    @Column(name = "price_per_unit", nullable = false)
    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @ManyToOne
    @JoinColumn(name = "measurement_unit_id", referencedColumnName = "id", nullable = false)
    public MeasurementUnit getMeasurementUnitByMeasurementUnitId() {
        return measurementUnitByMeasurementUnitId;
    }

    public void setMeasurementUnitByMeasurementUnitId(MeasurementUnit measurementUnitByMeasurementUnitId) {
        this.measurementUnitByMeasurementUnitId = measurementUnitByMeasurementUnitId;
    }

    @JsonBackReference(value="ingredientsByIngredientProductId")
    @OneToMany(mappedBy = "ingredientsByIngredientProductId")
    public Collection<OrderHasProducts> getOrderHasProductsById() {
        return orderHasProductsById;
    }

    public void setOrderHasProductsById(Collection<OrderHasProducts> orderHasProductsById) {
        this.orderHasProductsById = orderHasProductsById;
    }

    @JsonBackReference(value="ingredientsByIngredientId")
    @OneToMany(mappedBy = "ingredientsByIngredientId")
    public Collection<RecipeHasIngredients> getRecipeHasIngredientsById() {
        return recipeHasIngredientsById;
    }

    public void setRecipeHasIngredientsById(Collection<RecipeHasIngredients> recipeHasIngredientsById) {
        this.recipeHasIngredientsById = recipeHasIngredientsById;
    }
}
