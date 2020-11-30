package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderHasProductsTest {

    private OrderHasProducts orderHasProducts = new OrderHasProducts(0, 5, new Order(2), new Ingredient(2), new Recipe(2));

    @Test
    void getId() {
        assertEquals(0, orderHasProducts.getId());
    }

    @Test
    void setId() {
        orderHasProducts.setId(10);
        assertEquals(10, orderHasProducts.getId());
    }

    @Test
    void getQuantity() {
        assertEquals(5, orderHasProducts.getQuantity());
    }

    @Test
    void setQuantity() {
        orderHasProducts.setQuantity(15);
        assertEquals(15, orderHasProducts.getQuantity());
    }

    @Test
    void getOrdersByOrderId() {
        assertEquals(new Order(2), orderHasProducts.getOrdersByOrderId());
    }

    @Test
    void setOrdersByOrderId() {
        orderHasProducts.setOrdersByOrderId(new Order(25));
        assertEquals(new Order(25), orderHasProducts.getOrdersByOrderId());
    }

    @Test
    void getIngredientsByIngredientProductId() {
        assertEquals(new Ingredient(2), orderHasProducts.getIngredientsByIngredientProductId());
    }

    @Test
    void setIngredientsByIngredientProductId() {
        orderHasProducts.setIngredientsByIngredientProductId(new Ingredient(25));
        assertEquals(new Ingredient(25), orderHasProducts.getIngredientsByIngredientProductId());
    }

    @Test
    void getRecipesByRecipeProductId() {
        assertEquals(new Recipe(2), orderHasProducts.getRecipesByRecipeProductId());
    }

    @Test
    void setRecipesByRecipeProductId() {
        orderHasProducts.setRecipesByRecipeProductId(new Recipe(25));
        assertEquals(new Recipe(25), orderHasProducts.getRecipesByRecipeProductId());
    }

    @Test
    void testEquals() {
        assertNotEquals(new OrderHasProducts(), orderHasProducts);    //this one compares one with values inside
        assertEquals(new OrderHasProducts(), new OrderHasProducts());
    }

    @Test
    void testHashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + orderHasProducts.getId();
        result = result * PRIME + orderHasProducts.getQuantity();
        final Object $ordersByOrderId = orderHasProducts.getOrdersByOrderId();
        result = result * PRIME + ($ordersByOrderId == null ? 43 : $ordersByOrderId.hashCode());
        final Object $ingredientsByIngredientProductId = orderHasProducts.getIngredientsByIngredientProductId();
        result = result * PRIME + ($ingredientsByIngredientProductId == null ? 43 : $ingredientsByIngredientProductId.hashCode());
        final Object $recipesByRecipeProductId = orderHasProducts.getRecipesByRecipeProductId();
        result = result * PRIME + ($recipesByRecipeProductId == null ? 43 : $recipesByRecipeProductId.hashCode());

        assertEquals(result, orderHasProducts.hashCode());
    }
}