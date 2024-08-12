package com.semicolon.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter @Setter @ToString
public class CreditCardInformation {
    private String cardNumber;
    private String expiryMonth;
    private String expiryYear;
    private String cvv;
    private CardType cardType;
    @Id
    private String id;
}
