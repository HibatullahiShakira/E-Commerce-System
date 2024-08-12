package com.semicolon.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValidateUserRequest {
    private String password;
    private String emailAddress;
}
