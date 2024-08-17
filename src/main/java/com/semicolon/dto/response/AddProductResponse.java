package com.semicolon.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddProductResponse {
    private String productId;
    private String productName;
    private String message;
    private double price;
}
