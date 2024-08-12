package com.semicolon.dto.request;

import com.semicolon.data.model.Item;
import com.semicolon.data.model.OrderStatus;
import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
public class ShoppingCartItemDtoRequest {
    private Item items;
    private User user;
    private OrderStatus status;
    private String userId;
    private String tax;
    private BigDecimal totalPrice;
}
