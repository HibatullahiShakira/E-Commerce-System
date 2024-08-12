package com.semicolon.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter @Setter @ToString
public class BillingInformation {
    private String phoneNumber;
    private String email;
    private String deliveryAddress;
    private CreditCardInformation creditCardInformation;
    private User user;
    @Id
    private String id;
    private String name;
}
