package com.semicolon.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter @Setter
public class ShoppingCartItem {
    private Item items;
    @Id
    private String shoppingCartId;
    private LocalDateTime creationDate;
    private OrderStatus status;
    private String userId;
    private String taxRate;
    private BigDecimal totalPrice;
    private User user;
}
