package com.semicolon.dto.response;

import com.semicolon.data.model.Item;
import com.semicolon.data.model.OrderStatus;
import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
public class ShoppingCartItemUpdateResponse {
    private String message;
    private LocalDateTime creationDate;
    private OrderStatus status;
    private BigDecimal totalPrice;
}
