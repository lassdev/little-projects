package com.mycompany.spring.rest.repository;

import com.mycompany.spring.rest.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lsalvatierra on 2/5/2018.
 */
public interface PizzaRepository  extends JpaRepository<Pizza, Long> {
}
