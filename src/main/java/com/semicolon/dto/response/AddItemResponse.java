package com.semicolon.dto.response;

import com.semicolon.data.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
public class AddItemResponse {
    private String itemId;
    private double subTotal;
    private String message;
}
