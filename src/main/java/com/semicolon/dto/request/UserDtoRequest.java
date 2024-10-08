package com.semicolon.dto.request;

import com.semicolon.data.model.CreditCardInformation;
import com.semicolon.data.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDtoRequest {
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String password;
    private UserRole role;
    private int age;
    private String gender;
    private String address;
    private CreditCardInformation creditCardInformation;
}
