package com.example.demo.service;

import com.example.demo.model.Recipe;
import com.example.demo.model.RecipeHasIngredients;
import com.example.demo.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RecipeIntegrationTest {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    private TestEntityManager entityManager;

    Collection<RecipeHasIngredients> recipeHasIngredientsById = new ArrayList<>();


    @BeforeEach
    void fillCollection() {
        recipeHasIngredientsById.add(new RecipeHasIngredients(1));
        recipeHasIngredientsById.add(new RecipeHasIngredients(4));
    }

    @Test
    public void should_find_no_recipes_if_repository_is_empty(){
        Iterable<Recipe> recipes = recipeRepository.findAll();
        assertThat(recipes).isEmpty();
    }

    @Test
    public void should_store_recipe(){
        Recipe recipe = recipeRepository.save(new Recipe("name1", "description1", "author1",
                25, 30, 1, "instructions1", "iconSrc1",
                "imageSrc1", recipeHasIngredientsById));
        assertThat(recipe).hasFieldOrPropertyWithValue("name", "name1");
        assertThat(recipe).hasFieldOrPropertyWithValue("description", "description1");
        assertThat(recipe).hasFieldOrPropertyWithValue("author", "author1");
        assertThat(recipe).hasFieldOrPropertyWithValue("prepTime", 25);
        assertThat(recipe).hasFieldOrPropertyWithValue("cookTime", 30);
        assertThat(recipe).hasFieldOrPropertyWithValue("portions", 1);
        assertThat(recipe).hasFieldOrPropertyWithValue("instructions", "instructions1");
        assertThat(recipe).hasFieldOrPropertyWithValue("iconSrc", "iconSrc1");
        assertThat(recipe).hasFieldOrPropertyWithValue("imageSrc", "imageSrc1");
        assertThat(recipe).hasFieldOrPropertyWithValue("recipeHasIngredients", recipeHasIngredientsById);
    }

    @Test
    public void should_find_all_recipes(){

        recipeRepository.save(new Recipe("name1", "description1", "author1",
                25, 30, 1, "instructions1", "iconSrc1",
                "imageSrc1", recipeHasIngredientsById));
        recipeRepository.save(new Recipe("name2", "description2", "author2",
                15, 30, 1, "instructions2", "iconSrc2",
                "imageSrc2", recipeHasIngredientsById));
        recipeRepository.save(new Recipe("name3", "description3", "author3",
                20, 15, 1, "instructions3", "iconSrc3",
                "imageSrc1", recipeHasIngredientsById));

        Iterable<Recipe> recipes = recipeRepository.findAll();
        assertThat(recipes).hasSize(3);
    }

    @Test
    public void should_find_recipe_by_id() {
        Recipe r1 = new Recipe("name1", "description1", "author1",
                25, 30, 1, "instructions1", "iconSrc1",
                "imageSrc1", recipeHasIngredientsById);
        entityManager.persist(r1);

        Recipe r2 = new Recipe("name2", "description2", "author2",
                15, 30, 1, "instructions2", "iconSrc2",
                "imageSrc2", recipeHasIngredientsById);
        entityManager.persist(r2);

        Recipe foundRecipe = recipeRepository.findById(r2.getId()).get();
        assertThat(foundRecipe).isEqualTo(r2);
    }

    @Test
    public void should_delete_recipe_by_id() {
        Recipe r1 = new Recipe("name1", "description1", "author1",
                25, 30, 1, "instructions1", "iconSrc1",
                "imageSrc1", recipeHasIngredientsById);
        entityManager.persist(r1);

        Recipe r2 = new Recipe("name2", "description2", "author2",
                15, 30, 1, "instructions2", "iconSrc2",
                "imageSrc2", recipeHasIngredientsById);
        entityManager.persist(r2);

        Recipe r3 = new Recipe("name3", "description3", "author3",
                10, 15, 1, "instructions3", "iconSrc3",
                "imageSrc3", recipeHasIngredientsById);
        entityManager.persist(r3);

        recipeRepository.deleteById(r2.getId());

        Iterable<Recipe> recipes = recipeRepository.findAll();
        assertThat(recipes).hasSize(2).contains(r1, r3);
    }


    @Test
    public void should_find_recipe_by_keyword(){
        Recipe r1 = new Recipe("name1", "description1", "author1",
                25, 30, 1, "instructions1", "iconSrc1",
                "imageSrc1", recipeHasIngredientsById);
        entityManager.persist(r1);

        Recipe r2 = new Recipe("name2", "description2", "author2",
                15, 30, 1, "instructions2", "iconSrc2",
                "imageSrc2", recipeHasIngredientsById);
        entityManager.persist(r2);

        Recipe r3 = new Recipe("name3", "description3", "author3",
                10, 15, 1, "instructions3", "iconSrc3",
                "imageSrc3", recipeHasIngredientsById);
        entityManager.persist(r3);

        Iterable<Recipe> recipes1 = recipeRepository.findAllByKeyword("name1", PageRequest.of(0, 2));
        Iterable<Recipe> recipes2 = recipeRepository.findAllByKeyword("name3", PageRequest.of(0, 2));
        Iterable<Recipe> recipes3 = recipeRepository.findAllByKeyword("author2", PageRequest.of(0, 2));
        Iterable<Recipe> recipes4 = recipeRepository.findAllByKeyword("author1", PageRequest.of(0, 2));

        assertThat(recipes1).hasSize(2).contains(r1, r2);
        assertThat(recipes2).hasSize(2).contains(r1, r3);
        assertThat(recipes3).hasSize(2).contains(r2, r3);
        assertThat(recipes4).hasSize(1).contains(r1);
    }
}
