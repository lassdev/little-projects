package com.mycompany.spring.rest.controller;

import com.mycompany.spring.rest.model.OrderShop;
import com.mycompany.spring.rest.model.OrderStatus;
import com.mycompany.spring.rest.model.Pizza;
import com.mycompany.spring.rest.model.Product;
import com.mycompany.spring.rest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by lsalvatierra on 2/5/2018.
 */
@RestController
public class OrderController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository){
        this.orderRepository  = orderRepository;
    }


    @RequestMapping(method = RequestMethod.POST, value = "orders/add")
    public void add(){

        OrderShop orderShop = new OrderShop();
        orderShop.setStatusOrder(OrderStatus.PENDING.toString());

        orderRepository.save(orderShop);
    }

    @RequestMapping(method = RequestMethod.POST, value = "orders/{orderId}/addPizzaOrder")
    public void addPizzaOrder(@RequestBody ItemOrder itemOrder, @PathVariable Long orderId){

        OrderShop order = orderRepository.findOne(orderId);

        order.getPizzas().add(itemOrder.getPizza());
        orderRepository.save(order);
    }


    @RequestMapping(method = RequestMethod.POST, value = "orders/{orderId}/addProduct")
    public void addProductOrder(@RequestBody ItemOrder itemOrder, @PathVariable Long orderId){

        OrderShop order = orderRepository.findOne(orderId);

        order.getProduct().add(itemOrder.getProduct());
        orderRepository.save(order);
    }



    static class ItemOrder {
        private Pizza pizza;
        private Product product;


        public Pizza getPizza() {
            return pizza;
        }

        public void setPizza(Pizza pizza) {
            this.pizza = pizza;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }


}
