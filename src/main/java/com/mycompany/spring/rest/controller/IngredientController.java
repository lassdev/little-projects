package com.mycompany.spring.rest.controller;

import com.mycompany.spring.rest.model.Ingredient;
import com.mycompany.spring.rest.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lsalvatierra on 2/5/2018.
 */
@RestController
public class IngredientController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepository){
        this.ingredientRepository  = ingredientRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ingredients")
    public List<Ingredient> findAllUsers(){
        return ingredientRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ingredients/add")
    public void addUser(@RequestBody Ingredient model){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(model.getName());
        ingredient.setPrice(2.5);

        ingredientRepository.save(ingredient);

    }
}
