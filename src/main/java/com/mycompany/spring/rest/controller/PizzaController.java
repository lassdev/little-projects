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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @autor Luis Salvatierra
 */
@RestController
public class PizzaController {
    
    @RequestMapping("/pizza")
    public Pizza pizza(@RequestParam(value="name", defaultValue="World") String name) {                        
        Size medium = new Size(20.5, SizeType.MEDIUM);
        
        PizzaType pizzaType = new PizzaType();
        pizzaType.setName("Caprichosa");
        pizzaType.setDescription("Tocino, jamon, salame, aceitunas, chorizo");
        
        Pizza pizza = new Pizza();
        pizza.setSize(medium);
        pizza.setPizzaType(pizzaType);
        
        return pizza;
    }
    
}
