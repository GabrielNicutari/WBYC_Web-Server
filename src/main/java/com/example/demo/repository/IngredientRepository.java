package com.example.demo.repository;

import com.example.demo.model.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IngredientRepository extends JpaRepository<Dummy, Integer> {

}
