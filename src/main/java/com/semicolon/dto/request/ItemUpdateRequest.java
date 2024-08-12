package com.semicolon.dto.request;

import com.semicolon.data.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ItemUpdateRequest {
    private String itemId;
    private Product product;
    private int quantity;
}
