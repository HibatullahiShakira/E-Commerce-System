package com.semicolon.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ItemUpdateResponse {
    private String message;
    private BigDecimal subtotal;
}
