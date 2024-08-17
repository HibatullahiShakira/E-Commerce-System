package com.semicolon.dto.request;

import com.semicolon.data.model.BillingInformation;
import com.semicolon.data.model.CardType;
import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CreditCardInformationUpdateRequest {
    private String cardNumber;
    private String expiryMonth;
    private String expiryYear;
    private String cvv;
    private CardType cardType;
    private String cardHolderName;
    private User user;
    private String id;
}
