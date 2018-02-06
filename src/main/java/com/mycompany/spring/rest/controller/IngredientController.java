package com.mycompany.spring.rest.controller;

import com.mycompany.spring.rest.model.IngredientPizza;
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
    @RequestMapping(method = RequestMethod.GET, value = "/ingredients")
    public List<IngredientPizza> findAllOptional(){
        return ingredientRepository.findAll();
    }
   
    /***
     *
     * @param ingredientId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/ingredients/{id}")
    public ResponseEntity<IngredientPizza> getById(@PathVariable(value = "id") Long ingredientId){
        IngredientPizza ingredient = ingredientRepository.findOne(ingredientId);
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
    public IngredientPizza add(@RequestBody IngredientPizza model){
        IngredientPizza ingredient = new IngredientPizza();

        ingredient.setName(model.getName());
        ingredient.setDescription(model.getDescription());        
        ingredient.setType(model.getType());


        return ingredientRepository.save(ingredient);
    }


    /***
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/ingredients/update")
    public ResponseEntity<IngredientPizza> update(@Valid @RequestBody IngredientPizza model){
        IngredientPizza ingredient = ingredientRepository.findOne(model.getId());

        if(ingredient == null) {
            return ResponseEntity.notFound().build();
        }

        ingredient.setName(model.getName());
        ingredient.setDescription(model.getDescription());       
        ingredient.setType(model.getType());

        return ResponseEntity.ok(ingredientRepository.save(ingredient));

    }
}
