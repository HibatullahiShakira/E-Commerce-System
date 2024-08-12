package com.semicolon.dto.request;

import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeleteShoppingCartItemRequest {
    private User user;
}
