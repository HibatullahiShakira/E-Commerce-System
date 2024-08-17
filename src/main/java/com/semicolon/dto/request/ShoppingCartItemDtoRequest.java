package com.semicolon.dto.request;

import com.semicolon.data.model.Item;
import com.semicolon.data.model.OrderStatus;
import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Getter @Setter
public class ShoppingCartItemDtoRequest {
    private List<Item> items;
    @DBRef
    private User user;
    private OrderStatus status;
    private String userId;
    private int tax;
    private double totalPrice;
}
