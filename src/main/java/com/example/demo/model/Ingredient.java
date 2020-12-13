package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredients", schema = "wbyc")
public class Ingredient {
    private int id;
    private String name;
    private double pricePerUnit;
    private String imageSrc;
    private MeasurementUnit measurementUnitByMeasurementUnitId;

    public Ingredient(int id) {
        this.id = id;
    }

    public Ingredient( String name, double pricePerUnit, MeasurementUnit measurementUnitByMeasurementUnitId) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.measurementUnitByMeasurementUnitId = measurementUnitByMeasurementUnitId;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
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

    @Basic
    @Column(name = "price_per_unit", nullable = false)
    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Basic
    @Column(name ="image_src", nullable = true)
    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @ManyToOne
    @JoinColumn(name = "measurement_unit_id", referencedColumnName = "id", nullable = false)
    public MeasurementUnit getMeasurementUnitByMeasurementUnitId() {
        return measurementUnitByMeasurementUnitId;
    }

    public void setMeasurementUnitByMeasurementUnitId(MeasurementUnit measurementUnitByMeasurementUnitId) {
        this.measurementUnitByMeasurementUnitId = measurementUnitByMeasurementUnitId;
    }
}
