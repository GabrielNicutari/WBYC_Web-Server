package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Ingredient;
import com.example.demo.repository.IngredientRepository;
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
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;


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

    // fetch
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
        Page<Ingredient> pageItems;

        if(key == null) {
            pageItems = ingredientRepository.findAll(pagingSort);
        } else {
            pageItems = ingredientRepository.findAllByKeyword(key, pagingSort);
        }

        List<Ingredient> ingredients = pageItems.getContent();

        if (ingredients.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        // creating a customized response in case of an error
        Map<String, Object> response = new HashMap<>();
        response.put("ingredients", ingredients);
        response.put("currentPage", pageItems.getNumber());
        response.put("totalItems", pageItems.getTotalElements());
        response.put("totalPages", pageItems.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // create
    public ResponseEntity<Ingredient> createIngredient(Ingredient ingredient) {
        Ingredient _ingredient = ingredientRepository.save(ingredient);

        return new ResponseEntity<>(_ingredient, HttpStatus.CREATED);
    }
    
    // update
    public ResponseEntity<Ingredient> updateIngredient(int id, Ingredient ingredient) {
        Ingredient _ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found ingredient with id" + id));

        _ingredient.setName(ingredient.getName());
        _ingredient.setPricePerUnit(ingredient.getPricePerUnit());
        _ingredient.setMeasurementUnitByMeasurementUnitId(ingredient.getMeasurementUnitByMeasurementUnitId());

        return new ResponseEntity<>(ingredientRepository.save(ingredient), HttpStatus.OK);
    }

    // delete
    public ResponseEntity<HttpStatus> deleteIngredient(int id) {
        ingredientRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}