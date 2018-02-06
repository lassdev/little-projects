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
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;
    private String ciNit;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderShop> orderShops;


    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCiNit() {
        return ciNit;
    }

    public void setCiNit(String ciNit) {
        this.ciNit = ciNit;
    }

    public List<OrderShop> getOrderShops() {
        return orderShops;
    }

    public void setOrderShops(List<OrderShop> orderShops) {
        this.orderShops = orderShops;
    }
}
