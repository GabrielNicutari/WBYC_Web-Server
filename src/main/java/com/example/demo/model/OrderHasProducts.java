package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "order_has_products", schema = "wbyc")
public class OrderHasProducts {
    private int id;
    private int quantity;
    private Order ordersByOrderId;
    private Ingredient ingredientsByIngredientProductId;
    private Recipe recipesByRecipeProductId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderHasProducts that = (OrderHasProducts) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + quantity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    public Order getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(Order ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "ingredient_product_id", referencedColumnName = "id")
    public Ingredient getIngredientsByIngredientProductId() {
        return ingredientsByIngredientProductId;
    }

    public void setIngredientsByIngredientProductId(Ingredient ingredientsByIngredientProductId) {
        this.ingredientsByIngredientProductId = ingredientsByIngredientProductId;
    }

    @ManyToOne
    @JoinColumn(name = "recipe_product_id", referencedColumnName = "id")
    public Recipe getRecipesByRecipeProductId() {
        return recipesByRecipeProductId;
    }

    public void setRecipesByRecipeProductId(Recipe recipesByRecipeProductId) {
        this.recipesByRecipeProductId = recipesByRecipeProductId;
    }
}
