package com.severo.cloud.shoppingcart.controller;

import com.severo.cloud.shoppingcart.model.Cart;
import com.severo.cloud.shoppingcart.model.Item;
import com.severo.cloud.shoppingcart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        Optional<Cart> savedCart = shoppingCartRepository.findById(id);
        Cart cart = savedCart.orElseGet(() -> new Cart(id));
        cart.getItems().add(item);
        return shoppingCartRepository.save(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> findById(@PathVariable("id") Integer id) {
        return shoppingCartRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void clear(@PathVariable("id") Integer id) {
        shoppingCartRepository.deleteById(id);
    }
}
