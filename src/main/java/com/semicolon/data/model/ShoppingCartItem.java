package com.semicolon.data.model;

//import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Getter @Setter @Document
public class ShoppingCartItem {

    private List<Item> items;
    @Id
    private String shoppingCartId;
    private LocalDateTime creationDate;
    private OrderStatus status;
    private String userId;
    private int taxRate;
    private double totalPrice;
    @DBRef
    private User user;
}
