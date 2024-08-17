package com.semicolon.dto.request;

import com.semicolon.data.model.BillingInformation;
import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class GetCreditCardInformation {
    private User user;
}
