package com.example.demo.service;

import com.example.demo.model.Ingredient;
import com.example.demo.model.MeasurementUnit;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.MeasurementUnitRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IngredientIntegrationTest {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    MeasurementUnitRepository measurementUnitRepository;

    @Autowired
    private TestEntityManager entityManager;

    List<MeasurementUnit> measurementUnitList = new ArrayList<>();

    int initialSizeOfIngredients;
    
    @BeforeEach
    void fillCollection() {
        initialSizeOfIngredients = ingredientRepository.findAll().size();
        measurementUnitList = measurementUnitRepository.findAll();
    }

//    @Test
//    public void should_find_no_ingredients_if_repository_is_empty(){
//        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
//        assertThat(ingredients).isEmpty();
//    }
//
//
//    @Test
//    public void should_store_ingredient(){
//        Ingredient ingredient = ingredientRepository.save(new Ingredient("name1", 1.0, measurementUnitList.get(0)));
//        assertThat(ingredient).hasFieldOrPropertyWithValue("name", "name1");
//        assertThat(ingredient).hasFieldOrPropertyWithValue("pricePerUnit", 1.0);
//        assertThat(ingredient).hasFieldOrPropertyWithValue("measurementUnitByMeasurementUnitId", 10);
//    }


    @Test
    public void should_find_all_ingredients() {
        Ingredient ingredient = new Ingredient("name1", 1.0, measurementUnitList.get(0));

        ingredientRepository.save(ingredient);

        List<Ingredient> ingredients = ingredientRepository.findAll();
        assertThat(ingredients).hasSize(initialSizeOfIngredients + 1);

        ingredientRepository.delete(ingredient);
    }
//
//
//    @Test
//    public void should_find_ingredient_by_id() {
//        Ingredient i1 = new Ingredient("name1", 1.0, measurementUnitList.get(0));
//        entityManager.persist(i1);
//
//        Ingredient i2 = new Ingredient("name2", 2.0, measurementUnitList.get(0));
//        entityManager.persist(i2);
//
//        Ingredient foundIngredient = ingredientRepository.findById(i2.getId()).get();
//        assertThat(foundIngredient).isEqualTo(i2);
//    }
//
//
//    @Test
//    public void should_delete_ingredient_by_id() {
//        Ingredient i1 = new Ingredient("name1", 1.0, measurementUnitList.get(0));
//        entityManager.persist(i1);
//
//        Ingredient i2 = new Ingredient("name2", 2.0, measurementUnitList.get(0));
//        entityManager.persist(i2);
//
//        Ingredient i3 = new Ingredient("name3", 3.0, measurementUnitList.get(0));
//        entityManager.persist(i2);
//
//        ingredientRepository.deleteById(i2.getId());
//        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
//        assertThat(ingredients).hasSize(2).contains(i1, i3);
//    }
//
//
//    @Test
//    public void should_find_ingredient_by_keyword(){
//        Ingredient i1 = new Ingredient("name1", 1.0, measurementUnitList.get(0));
//        entityManager.persist(i1);
//
//        Ingredient i2 = new Ingredient("name2", 2.0, measurementUnitList.get(0));
//        entityManager.persist(i2);
//
//        Iterable<Ingredient> ingredients1 = ingredientRepository.findAllByKeyword("name2", PageRequest.of(0, 2));
//        Iterable<Ingredient> ingredients2 = ingredientRepository.findAllByKeyword("name1", PageRequest.of(0, 2));
//
//        assertThat(ingredients1).hasSize(2).contains(i1, i2);
//        assertThat(ingredients2).hasSize(1).contains(i1);
//    }
}
