package com.ms.cart_service.controllers;

import com.ms.cart_service.domins.Cart;
import com.ms.cart_service.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @PostMapping
    public Cart create(@RequestBody Cart request){
        return cartService.create(request);
    }
}
