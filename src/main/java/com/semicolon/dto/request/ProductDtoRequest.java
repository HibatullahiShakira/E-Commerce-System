package com.semicolon.dto.request;

import com.semicolon.data.model.ProductCategory;
import com.semicolon.data.model.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ProductDtoRequest {
    private UserRole userRole;
    private String productName;
    private String productDescription;
    private ProductCategory productCategory;
    private BigDecimal productPrice;
}
