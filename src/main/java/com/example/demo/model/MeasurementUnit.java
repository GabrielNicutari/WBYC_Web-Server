package com.example.demo.model;

import javax.persistence.*;
import java.util.Collection;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasurementUnit that = (MeasurementUnit) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "measurementUnitByMeasurementUnitId")
    public Collection<Ingredient> getIngredientsById() {
        return ingredientsById;
    }

    public void setIngredientsById(Collection<Ingredient> ingredientsById) {
        this.ingredientsById = ingredientsById;
    }
}
