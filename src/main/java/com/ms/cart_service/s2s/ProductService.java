package com.ms.cart_service.s2s;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@AllArgsConstructor
@Component
public class ProductService {

    private final RestTemplate restTemplate;
    private static final String apiUrl="http://localhost:4001/s2s/products";
    record ProductIsValidRequest(Set<String> ids){
    }

    public Boolean isProductValid(Set<String> productIds){
        try{
            if(productIds==null|| productIds.isEmpty())return true;
            ProductIsValidRequest productIsValidRequest=new ProductIsValidRequest(productIds);
            return restTemplate.postForObject(apiUrl + "/is-valid", productIsValidRequest, Boolean.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
