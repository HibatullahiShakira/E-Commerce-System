package com.semicolon.dto.response;

import com.semicolon.data.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
public class ItemDtoResponse {
    private String itemId;
    private Product product;
    private int quantity;
    private BigDecimal subTotal;
}
