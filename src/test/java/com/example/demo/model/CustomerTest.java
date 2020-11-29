package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    String str = "1990-03-31";
    Date date = Date.valueOf(str);

    Collection<Order> orders = new ArrayList<>();

    @BeforeEach
    void fillCollection() {
        orders.add(new Order(1));
        orders.add(new Order(4));
    }

    private Customer customer = new Customer(0,"James", "Copperfield", date, "UK",
            "Wolf Street", "London", "+447911123456", orders);

    @Test
    void getId() {

    }

    @Test
    void setId() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void setFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void getDateOfBirth() {
    }

    @Test
    void setDateOfBirth() {
    }

    @Test
    void getCountry() {
    }

    @Test
    void setCountry() {
    }

    @Test
    void getAddress() {
    }

    @Test
    void setAddress() {
    }

    @Test
    void getCity() {
    }

    @Test
    void setCity() {
    }

    @Test
    void getPhoneNumber() {
    }

    @Test
    void setPhoneNumber() {
    }

    @Test
    void getOrdersById() {
        Collection<Order> list = new ArrayList<>();
        list.add(new Order(1));
        list.add(new Order(4));
        
        assertEquals(list, customer.getOrdersById());
    }

    @Test
    void setOrdersById() {
        Collection<Order> list = new ArrayList<>();
        list.add(new Order(2));
        list.add(new Order(5));
        list.add(new Order(45));

        customer.setOrdersById(list);
        assertEquals(list, customer.getOrdersById());
    }

//    @Test
//    void testEquals() {
//    }
//
//    @Test
//    void canEqual() {
//    }
//
//    @Test
//    void testHashCode() {
//    }
}