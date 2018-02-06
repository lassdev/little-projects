package com.mycompany.spring.rest.controller;

import com.mycompany.spring.rest.model.PizzaType;
import com.mycompany.spring.rest.repository.PizzaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by lsalvatierra on 2/5/2018.
 */
@Controller
public class PizzaTypeController {

    private PizzaTypeRepository pizzaTypeRepository;

    @Autowired
    public PizzaTypeController(PizzaTypeRepository pizzaTypeRepository){
        this.pizzaTypeRepository  = pizzaTypeRepository;
    }


    /***
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pizzaTypes")
    public List<PizzaType> findAll(){
        return pizzaTypeRepository.findAll();
    }

    /***
     *
     * @param pizzaTypeId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pizzaTypes/{id}")
    public ResponseEntity<PizzaType> getById(@PathVariable(value = "id") Long pizzaTypeId){
        PizzaType pizzaType = pizzaTypeRepository.findOne(pizzaTypeId);
        if(pizzaType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pizzaType);
    }


    /***
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/pizzaTypes/add")
    public PizzaType add(@RequestBody PizzaType model){
        PizzaType pizzaType = new PizzaType();

        pizzaType.setName(model.getName());
        pizzaType.setDescription(model.getDescription());


        return pizzaTypeRepository.save(pizzaType);
    }


    /***
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/pizzaTypes/update")
    public ResponseEntity<PizzaType> update(@Valid @RequestBody PizzaType model){
        PizzaType pizzaType = pizzaTypeRepository.findOne(model.getId());

        if(pizzaType == null) {
            return ResponseEntity.notFound().build();
        }

        pizzaType.setName(model.getName());
        pizzaType.setDescription(model.getDescription());

        return ResponseEntity.ok(pizzaTypeRepository.save(pizzaType));

    }
}
