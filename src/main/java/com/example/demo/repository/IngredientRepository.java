package com.example.demo.repository;

import com.example.demo.model.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    @Query(value = "SELECT * FROM ingredients i WHERE (i.name LIKE CONCAT('%',:key,'%')) ", nativeQuery = true)
    Page<Ingredient> findAllByKeyword(@Param("key") String key, Pageable pageable);
}
