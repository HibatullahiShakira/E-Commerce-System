package com.semicolon.dto.response;

import com.semicolon.data.model.CardType;
import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreditCardInformationDtoResponse {
    private String cardNumber;
    private String expiryMonth;
    private String expiryYear;
    private String cvv;
    private CardType cardType;
    private String cardHolderName;
}
