package com.semicolon.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Getter @Setter @ToString
public class Item {
    @Id
    private String itemId;
    private Product product;
    private int quantity;
    private BigDecimal subTotal;

}
