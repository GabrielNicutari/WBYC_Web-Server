package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementUnitTest {

    private MeasurementUnit measurementUnit = new MeasurementUnit(2, "grams");

    @Test
    void getId() {
        assertEquals(2, measurementUnit.getId());
    }

    @Test
    void setId() {
        measurementUnit.setId(3);
        assertEquals(3, measurementUnit.getId());
    }

    @Test
    void getType() {
        assertEquals("grams", measurementUnit.getType());
    }

    @Test
    void setType() {
        measurementUnit.setType("pounds");
        assertEquals("pounds", measurementUnit.getType());
    }

    @Test
    void testEquals() {
        assertNotEquals(new MeasurementUnit(), measurementUnit);    //this one compares one with values inside
        assertEquals(new MeasurementUnit(), new MeasurementUnit());
    }

    @Test
    void testHashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + measurementUnit.getId();
        final Object $type = measurementUnit.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());

        assertEquals(result, measurementUnit.hashCode());
    }
}