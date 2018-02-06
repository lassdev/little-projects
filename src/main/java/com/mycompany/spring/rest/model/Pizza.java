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
public class Pizza implements Priceable {

    @Id
    @GeneratedValue
    private  Long id;
    // optional slices prefer customer
    private Integer slices;

    // force ingredients
    private String cheese;
    private String sauce;
    private String crust;    

    @OneToMany(
            cascade = CascadeType.ALL            
    )   
   private List<Topping> toopings;

    @OneToOne(
            cascade = CascadeType.ALL
    )
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

    public Integer getSlices() {
        return slices;
    }

    public void setSlices(Integer slices) {
        this.slices = slices;
    }   

    /**
     * @return the cheese
     */
    public String getCheese() {
        return cheese;
    }

    /**
     * @param cheese the cheese to set
     */
    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    /**
     * @return the sauce
     */
    public String getSauce() {
        return sauce;
    }

    /**
     * @param sauce the sauce to set
     */
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    /**
     * @return the crust
     */
    public String getCrust() {
        return crust;
    }

    /**
     * @param crust the crust to set
     */
    public void setCrust(String crust) {
        this.crust = crust;
    }

    /**
     * @return the toopings
     */
    public List<Topping> getToopings() {
        return toopings;
    }

    /**
     * @param toopings the toopings to set
     */
    public void setToopings(List<Topping> toopings) {
        this.toopings = toopings;
    }

    /**
     * @return the price
     */
    @Override
    public Double getPrice() {
        Double totalPrice =  size.getPrice();
        for(Topping topping : getToopings()){
            totalPrice += topping.getPrice();
        }
        
        return totalPrice;
    }

}
