package com.semicolon.dto.request;

import com.semicolon.data.model.CreditCardInformation;
import com.semicolon.data.model.User;
import com.semicolon.data.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BillingInformationDtoRequest {
    private User user;
    private String phoneNumber;
    private String email;
    private String deliveryAddress;
    private CreditCardInformation creditCardInformation;
    private String name;
}
