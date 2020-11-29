package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "measurement_unit", schema = "wbyc")
public class MeasurementUnit {
    private int id;
    private String type;
    private Collection<Ingredient> ingredientsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @OneToMany(mappedBy = "measurementUnitByMeasurementUnitId")
    public Collection<Ingredient> getIngredientsById() {
        return ingredientsById;
    }

    public void setIngredientsById(Collection<Ingredient> ingredientsById) {
        this.ingredientsById = ingredientsById;
    }
}
