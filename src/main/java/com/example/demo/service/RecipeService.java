package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Recipe;
import com.example.demo.model.RecipeHasIngredients;
import com.example.demo.repository.RecipeHasIngredientsRepository;
import com.example.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeHasIngredientsRepository recipeHasIngredientsRepository;

    // sorting based on the direction given by the user - asc or desc- default is desc
    private Sort.Direction getSortDirection(String direction) {
        if(direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if(direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.DESC;
    }

    private void sortedOrder(String[] sort, List<Sort.Order> orders) {

        // sort is broken into values made of field and direction if there are multiple sorting items
        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            //sort=[field,direction]
            orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
        }
    }

    private Map<String, Object> createResponse(List<Recipe> recipes, Page<Recipe> pageItems, int size) {

        Map<String, Object> response = new HashMap<>();

        response.put("recipes", recipes);
        response.put("size", size);
        response.put("currentPage", pageItems.getNumber());
        response.put("totalItems", pageItems.getTotalElements());
        response.put("totalPages", pageItems.getTotalPages());

        return response;
    }

    // FETCH
    public ResponseEntity<Map<String,Object>> getPageOfRecipes(
            String key
            ,int page
            ,int size
            ,String[] sort) {
        // orders will store the fields and the directions of sorting list given by the user
        List<Sort.Order> orders = new ArrayList<>();
        sortedOrder(sort, orders);

        // Paging
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
        Page<Recipe> pageItems;

        if(key == null) {
            pageItems = recipeRepository.findAll(pagingSort);
        } else {
            pageItems = recipeRepository.findAllByKeyword(key, pagingSort);
        }

        List<Recipe> recipes = pageItems.getContent();

        if (recipes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        // creating a customized response in case of an error
        return new ResponseEntity<>(createResponse(recipes, pageItems, size), HttpStatus.OK);
    }


    // CREATE
    public ResponseEntity<Recipe> createRecipe(Recipe recipe) {
        Recipe _recipe = recipeRepository.save(recipe);


        // the user has to store all the ingredients of the recipe
        Collection<RecipeHasIngredients> recipeHasIngredientsCollection = _recipe.getRecipeHasIngredientsById();

        for(RecipeHasIngredients recipeHasIngredients: recipeHasIngredientsCollection) {

            //recipeHasIngredients needs the foreign key first
            recipeHasIngredients.setRecipesByRecipeId(new Recipe(recipe.getId()));

            recipeHasIngredientsRepository.save(recipeHasIngredients);
        }

        return new ResponseEntity<>(_recipe, HttpStatus.CREATED);
    }


    // UPDATE
    public ResponseEntity<Recipe> updateRecipe(int id, Recipe recipe) {
        Recipe _recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe with id: " + id + " not found"));

        System.out.println(_recipe.getAuthor());

        _recipe.setName(recipe.getName());
        _recipe.setDescription(recipe.getDescription());
        _recipe.setAuthor(recipe.getAuthor());
        _recipe.setPrepTime(recipe.getPrepTime());
        _recipe.setCookTime(recipe.getCookTime());
        _recipe.setPortions(recipe.getPortions());
        _recipe.setIconSrc(recipe.getIconSrc());
        _recipe.setImageSrc(recipe.getImageSrc());
        _recipe.setPrice(recipe.getPrice());


        return new ResponseEntity<>(recipeRepository.save(_recipe), HttpStatus.OK);
    }


    // DELETE
    public ResponseEntity<HttpStatus> deleteRecipe(int id) {
        recipeRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    public ResponseEntity<Recipe> getRecipe(int id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found recipe with id = " + id));
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }
}

