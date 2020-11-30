package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    String str = "2020-10-31";
    Date date = Date.valueOf(str);

    Collection<OrderHasProducts> orderHasProducts = new ArrayList<>();

    @BeforeEach
    void fillCollection() {
        orderHasProducts.add(new OrderHasProducts(1));
        orderHasProducts.add(new OrderHasProducts(4));
    }

    private final Order order = new Order(0, "w/e", date, orderHasProducts, new Customer(2), new Status(2));

    @Test
    void getId() {
        assertEquals(0, order.getId());
    }

    @Test
    void setId() {
        order.setId(33);
        assertEquals(33, order.getId());
    }

    @Test
    void getComments() {
        assertEquals("w/e", order.getComments());
    }

    @Test
    void setComments() {
        order.setComments("hmm");
        assertEquals("hmm", order.getComments());
    }

    @Test
    void getOrderDate() {
        assertEquals(date, order.getOrderDate());
    }

    @Test
    void setOrderDate() {
        String str = "2000-05-25";
        Date date1 = Date.valueOf(str);
        order.setOrderDate(date1);
        assertEquals(date1, order.getOrderDate());
    }

    @Test
    void getOrderHasProductsById() {
        Collection<OrderHasProducts> list = new ArrayList<>();
        list.add(new OrderHasProducts(1));
        list.add(new OrderHasProducts(4));
        assertEquals(list, order.getOrderHasProductsById());
    }

    @Test
    void setOrderHasProductsById() {
        Collection<OrderHasProducts> list = new ArrayList<>();
        list.add(new OrderHasProducts(2));
        list.add(new OrderHasProducts(5));
        list.add(new OrderHasProducts(45));

        order.setOrderHasProductsById(list);

        assertEquals(list, order.getOrderHasProductsById());
    }

    @Test
    void getCustomersByCustomerId() {
        assertEquals(new Customer(2), order.getCustomersByCustomerId());
    }

    @Test
    void setCustomersByCustomerId() {
        order.setCustomersByCustomerId(new Customer(20));
        assertEquals(new Customer(20), order.getCustomersByCustomerId());
    }

    @Test
    void getStatusesByStatusId() {
        assertEquals(new Status(2), order.getStatusesByStatusId());
    }

    @Test
    void setStatusesByStatusId() {
        order.setStatusesByStatusId(new Status(20));
        assertEquals(new Status(20), order.getStatusesByStatusId());
    }

    @Test
    void testEquals() {
        assertNotEquals(new Order(), order);    //this one compares one with values inside
        assertEquals(new Order(), new Order());
    }

    @Test
    void testHashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + order.getId();
        final Object $comments = order.getComments();
        result = result * PRIME + ($comments == null ? 43 : $comments.hashCode());
        final Object $orderDate = order.getOrderDate();
        result = result * PRIME + ($orderDate == null ? 43 : $orderDate.hashCode());
        final Object $orderHasProductsById = order.getOrderHasProductsById();
        result = result * PRIME + ($orderHasProductsById == null ? 43 : $orderHasProductsById.hashCode());
        final Object $customersByCustomerId = order.getCustomersByCustomerId();
        result = result * PRIME + ($customersByCustomerId == null ? 43 : $customersByCustomerId.hashCode());
        final Object $statusesByStatusId = order.getStatusesByStatusId();
        result = result * PRIME + ($statusesByStatusId == null ? 43 : $statusesByStatusId.hashCode());

        assertEquals(result, order.hashCode());
    }
}