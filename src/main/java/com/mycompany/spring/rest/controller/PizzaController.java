/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest.controller;

import com.mycompany.spring.rest.model.Pizza;
import com.mycompany.spring.rest.model.PizzaType;
import com.mycompany.spring.rest.model.Size;
import com.mycompany.spring.rest.model.SizeType;
import com.mycompany.spring.rest.repository.OrderRepository;
import com.mycompany.spring.rest.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @autor Luis Salvatierra
 */
@RestController
public class PizzaController {

    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaController(PizzaRepository pizzaRepository){
        this.pizzaRepository  = pizzaRepository;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/pizzas"
    )
    public List<Pizza> findAllPizzas() {
        return pizzaRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/pizzas/add"
    )
    public Pizza findAllPizzas(@RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }
    
}
