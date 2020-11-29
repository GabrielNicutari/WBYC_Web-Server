package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "orders", schema = "wbyc")
public class Order {
    private int id;
    private String comments;
    private Date orderDate;
    private Collection<OrderHasProducts> orderHasProductsById;
    private Customer customersByCustomerId;
    private Status statusesByStatusId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = 256)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "order_date", nullable = false)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    public Collection<OrderHasProducts> getOrderHasProductsById() {
        return orderHasProductsById;
    }

    public void setOrderHasProductsById(Collection<OrderHasProducts> orderHasProductsById) {
        this.orderHasProductsById = orderHasProductsById;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    public Customer getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(Customer customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    public Status getStatusesByStatusId() {
        return statusesByStatusId;
    }

    public void setStatusesByStatusId(Status statusesByStatusId) {
        this.statusesByStatusId = statusesByStatusId;
    }
}
