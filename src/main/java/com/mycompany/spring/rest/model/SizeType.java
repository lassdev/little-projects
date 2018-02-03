/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest.model;

/**
 *
 * @author HOUSE
 */
public enum SizeType {
    
    PERSONAL("Personal", 2),
    SMALL("Small",6),
    MEDIUM("Medium", 12),
    LARGE("Large", 18);
    
    private final String name;
    private final Integer slices;

    private SizeType(String name, Integer slices) {
        this.name = name;
        this.slices = slices;
    }            

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the slices
     */
    public Integer getSlices() {
        return slices;
    }
}
