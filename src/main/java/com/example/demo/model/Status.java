package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "statuses", schema = "wbyc")
public class Status {
    private int id;
    private String name;
    private Collection<Order> ordersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "statusesByStatusId")
    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }
}
