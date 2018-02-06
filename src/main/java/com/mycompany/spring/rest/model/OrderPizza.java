package com.mycompany.spring.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lsalvatierra on 2/5/2018.
 */
@Entity
public class OrderPizza implements Priceable{

    @Id
    @GeneratedValue
    private Long id;

    private Pizza pizza;
    private Integer amount;
   

    public Long getId() {
        return id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    @Override
    public Double getPrice(){
        return pizza.getPrice() * amount;
    }
}
