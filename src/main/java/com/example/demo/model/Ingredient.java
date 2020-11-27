package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

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
    @Column(name = "price_per_unit", nullable = false, precision = 0)
    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (id != that.id) return false;
        if (Double.compare(that.pricePerUnit, pricePerUnit) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(pricePerUnit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "measurement_unit_id", referencedColumnName = "id", nullable = false)
    public MeasurementUnit getMeasurementUnitByMeasurementUnitId() {
        return measurementUnitByMeasurementUnitId;
    }

    public void setMeasurementUnitByMeasurementUnitId(MeasurementUnit measurementUnitByMeasurementUnitId) {
        this.measurementUnitByMeasurementUnitId = measurementUnitByMeasurementUnitId;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "ingredientsByIngredientProductId")
    public Collection<OrderHasProducts> getOrderHasProductsById() {
        return orderHasProductsById;
    }

    public void setOrderHasProductsById(Collection<OrderHasProducts> orderHasProductsById) {
        this.orderHasProductsById = orderHasProductsById;
    }

    @OneToMany(mappedBy = "ingredientsByIngredientId")
    public Collection<RecipeHasIngredients> getRecipeHasIngredientsById() {
        return recipeHasIngredientsById;
    }

    public void setRecipeHasIngredientsById(Collection<RecipeHasIngredients> recipeHasIngredientsById) {
        this.recipeHasIngredientsById = recipeHasIngredientsById;
    }
}
