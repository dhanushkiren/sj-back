package com.example.ecommerce.controller;

import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private JwtService jwtService;

    @GetMapping
    public List<CartItem> getCart() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return cartService.getCartByUsername(username).getItems();
    }

    @PostMapping("/add")
    public void addItemToCart(@RequestBody CartItem item) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("Received item: " + item);

        cartService.addItemToCart(username, item);
    }

    @DeleteMapping("/remove/{productId}")
    public void removeItemFromCart(@PathVariable String productId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.removeItemFromCart(username, productId);
    }

    @PostMapping("/clear")
    public void clearCart() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.clearCart(username);
    }
}
