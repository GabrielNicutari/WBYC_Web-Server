package com.example.demo.repository;

import com.example.demo.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query( value = "SELECT * FROM recipes r WHERE r.name LIKE CONCAT('%',:key,'%') " +
            "OR r.author LIKE CONCAT('%',:key,'%')", nativeQuery = true )
    Page<Recipe> findAllByKeyword(@Param("key") String key, Pageable pageable);
}
