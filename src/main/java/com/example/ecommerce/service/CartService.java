package com.example.ecommerce.service;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByUsername(String username) {
        return cartRepository.findByUsername(username).orElse(new Cart());
    }

    public void addItemToCart(String username, CartItem item) {
        Cart cart = getCartByUsername(username);
        cart.getItems().add(item);
        cart.setUsername(username);
        cartRepository.save(cart);
    }

    public void removeItemFromCart(String username, String productId) {
        Cart cart = getCartByUsername(username);
        cart.setItems(cart.getItems().stream()
                .filter(item -> !item.getProductId().equals(productId))
                .collect(Collectors.toList()));
        cartRepository.save(cart);
    }

    public void clearCart(String username) {
        Cart cart = getCartByUsername(username);
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
