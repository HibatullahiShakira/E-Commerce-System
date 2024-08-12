package com.semicolon.dto.request;

import com.semicolon.data.model.CreditCardInformation;
import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BillingInformationUpdateRequest {
    private User user;
    private String phoneNumber;
    private String email;
    private String deliveryAddress;
    private CreditCardInformation creditCardInformation;
    private String Id;
    private String name;
}
