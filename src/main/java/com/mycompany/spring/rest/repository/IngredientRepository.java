package com.mycompany.spring.rest.repository;

import com.mycompany.spring.rest.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lsalvatierra on 2/5/2018.
 */
@Repository
public interface IngredientRepository  extends JpaRepository<Ingredient, Long> {
}
