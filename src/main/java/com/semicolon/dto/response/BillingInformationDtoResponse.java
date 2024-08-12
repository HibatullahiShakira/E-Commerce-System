package com.semicolon.dto.response;

import com.semicolon.data.model.CreditCardInformation;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BillingInformationDtoResponse {
    private String phoneNumber;
    private String email;
    private String deliveryAddress;
    private CreditCardInformation creditCardInformation;
    private String Id;
}
