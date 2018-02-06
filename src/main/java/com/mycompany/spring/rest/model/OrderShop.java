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
 * @author  lsalvatierra
 */
@Entity(name = "OrderShop")
@Table(name="order_shop")
public class OrderShop {

    @Id
    @GeneratedValue
    private Long id;

    private Double totalPrice;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<OrderPizza> pizzas;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Product> product;

    private String statusOrder;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderPizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<OrderPizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Long getId() {
        return id;
    }
}
