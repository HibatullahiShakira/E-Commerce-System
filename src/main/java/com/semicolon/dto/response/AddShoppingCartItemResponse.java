package com.semicolon.dto.response;

import com.semicolon.data.model.Item;
import com.semicolon.data.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter @Getter
public class AddShoppingCartItemResponse {
    private LocalDateTime creationDate = LocalDateTime.now();
    private OrderStatus status;
    private String userId;
    private BigDecimal totalPrice;
    private String message;
    private String shoppingCartId;
}
