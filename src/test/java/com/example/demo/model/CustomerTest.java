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
        assertEquals(0,customer.getId());
    }

    @Test
    void setId() {
        customer.setId(1);
        assertEquals(1, customer.getId());
    }

    @Test
    void getFirstName() {
        assertEquals("James", customer.getFirstName());
    }

    @Test
    void setFirstName() {
        customer.setFirstName("Kate");
        assertEquals("Kate", customer.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Copperfield", customer.getLastName());
    }

    @Test
    void setLastName() {
        customer.setLastName("Thompson");
        assertEquals("Thompson", customer.getLastName());
    }

    @Test
    void getDateOfBirth() {
        assertEquals(date, customer.getDateOfBirth());
    }

    @Test
    void setDateOfBirth() {
        String str = "2000-05-25";
        Date date1 = Date.valueOf(str);
        customer.setDateOfBirth(date1);
        assertEquals(date1, customer.getDateOfBirth());
    }

    @Test
    void getCountry() {
        assertEquals("UK", customer.getCountry());
    }

    @Test
    void setCountry() {
        customer.setCountry("DK");
        assertEquals("DK", customer.getCountry());
    }

    @Test
    void getAddress() {
        assertEquals("Wolf Street", customer.getAddress());
    }

    @Test
    void setAddress() {
        customer.setAddress("Amagerbro");
        assertEquals("Amagerbro", customer.getAddress());
    }

    @Test
    void getCity() {
        assertEquals("London", customer.getCity());
    }

    @Test
    void setCity() {
        customer.setCity("Copenhagen");
        assertEquals("Copenhagen", customer.getCity());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("+447911123456", customer.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        customer.setPhoneNumber("+4550658723");
        assertEquals("+4550658723", customer.getPhoneNumber());
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

    @Test
    void testEquals() {
        assertNotEquals(new Customer(), customer);    //this one compares one with values inside
        assertEquals(new Customer(), new Customer());
    }

    @Test
    void testHashCode() {
        int result = customer.getId();
        result = 31 * result + (customer.getFirstName() != null ? customer.getFirstName().hashCode() : 0);
        result = 31 * result + (customer.getLastName() != null ? customer.getLastName().hashCode() : 0);
        result = 31 * result + (customer.getDateOfBirth() != null ? customer.getDateOfBirth().hashCode() : 0);
        result = 31 * result + (customer.getCountry() != null ? customer.getCountry().hashCode() : 0);
        result = 31 * result + (customer.getAddress() != null ? customer.getAddress().hashCode() : 0);
        result = 31 * result + (customer.getCity() != null ? customer.getCity().hashCode() : 0);
        result = 31 * result + (customer.getPhoneNumber() != null ? customer.getPhoneNumber().hashCode() : 0);
        assertEquals(result, customer.hashCode());
    }
}