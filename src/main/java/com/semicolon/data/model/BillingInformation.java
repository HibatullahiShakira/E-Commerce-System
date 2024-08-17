package com.semicolon.data.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @Document
public class BillingInformation {
    private String phoneNumber;
    private String email;
    private String deliveryAddress;
    private CreditCardInformation creditCardInformation;
    @DBRef
    private User user;
    @Id
    private String id;
    private String name;
}
