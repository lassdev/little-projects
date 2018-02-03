/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest.model;

import java.util.List;

/**
 *
 * @author HOUSE
 */
public class Pizza {
                
    
    private Size size;
    private PizzaType pizzaType;
    private List<Ingredient> ingredients;

    /**
     * @return the size
     */
    public Size getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * @return the pizzaType
     */
    public PizzaType getPizzaType() {
        return pizzaType;
    }

    /**
     * @param pizzaType the pizzaType to set
     */
    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    /**
     * @return the ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
                    
}
