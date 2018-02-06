package com.mycompany.spring.rest.controller;

import com.mycompany.spring.rest.model.Ingredient;
import com.mycompany.spring.rest.model.OptionType;
import com.mycompany.spring.rest.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    /***
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/ingredients/optional")
    public List<Ingredient> findAllOptional(){
        return ingredientRepository.findAll();
    }

    /***
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/ingredients/mandatory")
    public List<Ingredient> findAllMandatory(){
        return ingredientRepository.findAll();
    }

    /***
     *
     * @param ingredientId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/ingredients/{id}")
    public ResponseEntity<Ingredient> getById(@PathVariable(value = "id") Long ingredientId){
        Ingredient ingredient = ingredientRepository.findOne(ingredientId);
        if(ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(ingredient);
    }

    /***
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/ingredients/add")
    public Ingredient add(@RequestBody Ingredient model){
        Ingredient ingredient = new Ingredient();

        ingredient.setName(model.getName());
        ingredient.setDescription(model.getDescription());
        ingredient.setOptionType(model.getOptionType());
        ingredient.setIngredientType(model.getIngredientType());


        return ingredientRepository.save(ingredient);
    }


    /***
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/ingredients/update")
    public ResponseEntity<Ingredient> update(@Valid @RequestBody Ingredient model){
        Ingredient ingredient = ingredientRepository.findOne(model.getId());

        if(ingredient == null) {
            return ResponseEntity.notFound().build();
        }

        ingredient.setName(model.getName());
        ingredient.setDescription(model.getDescription());
        ingredient.setOptionType(model.getOptionType());
        ingredient.setIngredientType(model.getIngredientType());

        return ResponseEntity.ok(ingredientRepository.save(ingredient));

    }
}
