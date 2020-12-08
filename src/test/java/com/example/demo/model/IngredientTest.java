package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    private final Ingredient ingredient = new Ingredient(0, "Salt", 1.5,
            "https://p7.hiclipart.com/preview/114/422/487/loin-pain-hematuria-syndrome-magnesium-sulfate-preventive-healthcare-salt-salt-thumbnail.jpg",
            new MeasurementUnit(10));

    @Test
    void getId() {
        assertEquals(0, ingredient.getId());
    }

    @Test
    void setId() {
        ingredient.setId(1);
        assertEquals(1, ingredient.getId());
    }

    @Test
    void getName() {
        assertEquals("Salt", ingredient.getName());
    }

    @Test
    void setName() {
        ingredient.setName("Paprika");
        assertEquals("Paprika", ingredient.getName());
    }

    @Test
    void getPricePerUnit() {
        assertEquals(1.5, ingredient.getPricePerUnit());
    }

    @Test
    void setPricePerUnit() {
        ingredient.setPricePerUnit(2.2);
        assertEquals(2.2, ingredient.getPricePerUnit());
    }

    @Test
    void getMeasurementUnitByMeasurementUnitId() {
        assertEquals(new MeasurementUnit(10), ingredient.getMeasurementUnitByMeasurementUnitId());
    }

    @Test
    void setMeasurementUnitByMeasurementUnitId() {
        ingredient.setMeasurementUnitByMeasurementUnitId(new MeasurementUnit(25));
        assertEquals(new MeasurementUnit(25), ingredient.getMeasurementUnitByMeasurementUnitId());
    }

    @Test
    void testEquals() {
        assertNotEquals(new Ingredient(), ingredient);    //this one compares one with values inside
        assertEquals(new Ingredient(), new Ingredient());
    }

    @Test
    void testHashCode() {
//        final int PRIME = 59;
//        int result = 1;
//        result = result * PRIME + ingredient.getId();
//        final Object $name = ingredient.getName();
//        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
//        final long $pricePerUnit = Double.doubleToLongBits(ingredient.getPricePerUnit());
//        result = result * PRIME + (int) ($pricePerUnit >>> 32 ^ $pricePerUnit);
//        final Object $measurementUnitByMeasurementUnitId = ingredient.getMeasurementUnitByMeasurementUnitId();
//        result = result * PRIME + ($measurementUnitByMeasurementUnitId == null ? 43 : $measurementUnitByMeasurementUnitId.hashCode());
//
//        System.out.println(result + " " + ingredient.hashCode());
//        assertEquals(result, ingredient.hashCode());
    }
}