package com.severo.cloud.shoppingcart.repository;

import com.severo.cloud.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<Cart, Integer> {
    Cart findByCustomerId(Integer customerId);
}
