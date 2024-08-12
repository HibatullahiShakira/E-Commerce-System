package com.semicolon.dto.request;

import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetShoppingCartItemDtoRequest {
    private String shoppingCartId;
    private User user;
}
