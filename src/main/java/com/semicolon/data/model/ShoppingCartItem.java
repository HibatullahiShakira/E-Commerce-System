package com.semicolon.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @ToString
public class ShoppingCart {
    private Item items;
    @Id
    private String id;
    private LocalDateTime creationDate;
    private String orderStatus;
    private BigDecimal productPrice;
    private OrderStatus status;
}
