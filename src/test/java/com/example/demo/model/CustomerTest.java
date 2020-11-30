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

    private final Customer customer = new Customer(0,"James", "Copperfield", date, "UK",
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
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + customer.getId();
        final Object $firstName = customer.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = customer.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $dateOfBirth = customer.getDateOfBirth();
        result = result * PRIME + ($dateOfBirth == null ? 43 : $dateOfBirth.hashCode());
        final Object $country = customer.getCountry();
        result = result * PRIME + ($country == null ? 43 : $country.hashCode());
        final Object $address = customer.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $city = customer.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $phoneNumber = customer.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        final Object $ordersById = customer.getOrdersById();
        result = result * PRIME + ($ordersById == null ? 43 : $ordersById.hashCode());

        assertEquals(result, customer.hashCode());
    }
}