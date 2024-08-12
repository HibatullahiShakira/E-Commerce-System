package com.semicolon.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Getter @Setter
public class Product {
    private UserRole userRole;
    private String productName;
    private String productDescription;
    @Id
    private String id;
    private ProductCategory productCategory;
    private BigDecimal price;
}
