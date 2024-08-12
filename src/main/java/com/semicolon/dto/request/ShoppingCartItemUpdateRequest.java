package com.semicolon.dto.request;

import com.semicolon.data.model.Item;
import com.semicolon.data.model.OrderStatus;
import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter @Getter
public class ShoppingCartItemUpdateRequest {
    private Item items;
    private OrderStatus status;
    private String userId;
    private String taxRate;
    private String id;
    private User user;
}
