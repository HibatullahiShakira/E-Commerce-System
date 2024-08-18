package com.semicolon.data.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter @Setter @Document
public class Product {
    private UserRole userRole;
    private String productName;
    private String productDescription;
    @Id
    private String id;
    private ProductCategory productCategory;
    private double price;
    private Binary image;
}
