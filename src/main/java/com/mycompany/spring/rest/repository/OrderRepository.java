package com.mycompany.spring.rest.repository;

import com.mycompany.spring.rest.model.OrderShop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lsalvatierra on 2/5/2018.
 */
public interface OrderRepository  extends JpaRepository<OrderShop, Long> {

}
