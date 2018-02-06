package com.mycompany.spring.rest.controller;

import com.mycompany.spring.rest.model.*;
import com.mycompany.spring.rest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public List<OrderShop> findAllOrders(){
        return orderRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "orders/{orderId}/addPizzaOrder")
    public void addPizzaOrder(@RequestBody ItemOrder itemOrder, @PathVariable Long orderId){

        OrderShop order = orderRepository.findOne(orderId);
            

        for(OrderPizza orderItem : itemOrder.getOrderPizzas()){
            OrderPizza instance = new OrderPizza();
            instance.setAmount(orderItem.getAmount() == null ? 1 : orderItem.getAmount());
            instance.setPizza(orderItem.getPizza());
            order.getPizzas().add(instance);
        }
        
        
        order.setStatusOrder(OrderStatus.CONFIRMED.toString());        
        orderRepository.save(order);

    }


//    @RequestMapping(method = RequestMethod.POST, value = "orders/{orderId}/addProduct")
//    public void addProductOrder(@RequestBody ItemOrder itemOrder, @PathVariable Long orderId){
//        // Not supported yet
//    }



    static class ItemOrder {
        private List<OrderPizza> orderPizzas;
        private Customer customer;

        public List<OrderPizza> getOrderPizzas() {
            return orderPizzas;
        }

        public void setOrderPizzas(List<OrderPizza> orderPizzas) {
            this.orderPizzas = orderPizzas;
        }

        /**
         * @return the customer
         */
        public Customer getCustomer() {
            return customer;
        }

        /**
         * @param customer the customer to set
         */
        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
    }


}
