package com.semicolon.data.model;

//import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter @Setter @ToString @Document
public class Item {
    @Id
    private String itemId;
//    @ManyToOne
    private Product product;
    private int quantity;
    private double subTotal;

}
