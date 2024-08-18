package com.semicolon.dto.response;

import com.semicolon.data.model.ProductCategory;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;

import java.math.BigDecimal;

@Setter @Getter
public class ProductDtoResponse {
    private String id;
    private String productName;
    private String productDescription;
    private ProductCategory productCategory;
    private double productPrice;
    private Binary productImage;
}
