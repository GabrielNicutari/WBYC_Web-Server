package com.example.demo.repository;

import com.example.demo.model.MeasurementUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Integer> {
}
