package com.ms.cart_service.controllers.s2s;

import com.ms.cart_service.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s2s/carts")
@RequiredArgsConstructor
public class CartS2sController {
    private final CartService cartService;

    @GetMapping("/{userId}")
    public Object getCartDetails(@PathVariable String userId){
        return cartService.getCartDetails(userId);
    }

}
