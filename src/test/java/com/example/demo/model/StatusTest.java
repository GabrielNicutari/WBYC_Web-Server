package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    private final Status status = new Status(0, "active");

    @Test
    void getId() {
        assertEquals(0, status.getId());
    }

    @Test
    void setId() {
        status.setId(2);
        assertEquals(2, status.getId());
    }

    @Test
    void getName() {
        assertEquals("active", status.getName());
    }

    @Test
    void setName() {
        status.setName("completed");
        assertEquals("completed", status.getName());
    }

    @Test
    void testEquals() {
        assertNotEquals(new Status(), status);    //this one compares one with values inside
        assertEquals(new Status(), new Status());
    }

    @Test
    void testHashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + status.getId();
        final Object $name = status.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());

        assertEquals(result, status.hashCode());
    }
}