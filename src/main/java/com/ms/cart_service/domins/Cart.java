package com.ms.cart_service.domins;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb",nullable = false)
    private List<CartProduct> products;

    @Column(nullable = false)
    private String userId;

    @Enumerated(EnumType.STRING)
    private CartStatus status=CartStatus.Created;
}
