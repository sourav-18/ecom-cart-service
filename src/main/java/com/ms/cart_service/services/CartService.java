package com.ms.cart_service.services;

import com.ms.cart_service.domins.Cart;
import com.ms.cart_service.domins.CartProduct;
import com.ms.cart_service.domins.CartStatus;
import com.ms.cart_service.repositories.CartRepository;
import com.ms.cart_service.s2s.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;

    public Cart create(Cart request){
        System.out.println("-----------------------------enter------------------");
        Boolean isValid=productService.isProductValid(request.getProducts()
                .stream().map(CartProduct::getId).collect(Collectors.toSet()));
        System.out.println("-----------------------------after------------------");
        if(!isValid){
            throw new RuntimeException("product not found");
        }
        return cartRepository.save(request);
    }

    public Object getCartDetails(String userId){
        Cart cart = cartRepository.findByUserIdAndStatus(userId, CartStatus.Created)
                .orElseThrow(()->new RuntimeException("User cart not found"));
        return cart;
    }
}
