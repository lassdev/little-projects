/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author HOUSE
 */
@Entity
public class Size {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double price;
    private Integer slices;

    
    public Size(){}
    public Size(Double price, SizeType sizeType){
        this.price = price;
        this.name = sizeType.getName();
        this.slices = sizeType.getSlices();
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the slices
     */
    public Integer getSlices() {
        return slices;
    }

    /**
     * @param slices the slices to set
     */
    public void setSlices(Integer slices) {
        this.slices = slices;
    }

    public Long getId() {
        return id;
    }
}
