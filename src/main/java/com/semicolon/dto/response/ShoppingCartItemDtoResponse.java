package com.semicolon.dto.response;

import com.semicolon.data.model.Item;
import com.semicolon.data.model.OrderStatus;
import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class ShoppingCartItemDtoResponse {
    private List<Item> items;
    private String shoppingCartId;
    private LocalDateTime creationDate;
    private OrderStatus status;
    private String userId;
    private int taxRate;
    private double totalPrice;
    private User user;
}
