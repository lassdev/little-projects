/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest.model;

import javax.persistence.*;
import java.util.List;


/**
 *
 * @author HOUSE
 */
@Entity
public class Pizza {

    @Id
    @GeneratedValue
    private  Long id;


    // optional slices prefer customer
    private Integer slices;

    // force ingredients
    @OneToOne(
            cascade = CascadeType.ALL
    )
    private Ingredient cheese;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    private Ingredient sauce;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    private Ingredient crust;

    @OneToOne(
            cascade = CascadeType.ALL
    )

//    /***
//     * Optional Ingredients
//     */
//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//
//    private List<Ingredient> ingredients;

    private Size size;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    private PizzaType pizzaType;

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

//    /**
//     * @return the ingredients
//     */
//    public List<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    /**
//     * @param ingredients the ingredients to set
//     */
//    public void setIngredients(List<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }


    public Integer getSlices() {
        return slices;
    }

    public void setSlices(Integer slices) {
        this.slices = slices;
    }

    public Ingredient getCheese() {
        return cheese;
    }

    public void setCheese(Ingredient cheese) {
        this.cheese = cheese;
    }

    public Ingredient getSauce() {
        return sauce;
    }

    public void setSauce(Ingredient sauce) {
        this.sauce = sauce;
    }

    public Ingredient getCrust() {
        return crust;
    }

    public void setCrust(Ingredient crust) {
        this.crust = crust;
    }
}
