package com.semicolon.dto.response;

import com.semicolon.data.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDtoResponse {
    private String userId;
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String password;
    private UserRole role;
    private int age;
    private String gender;
    private String address;
}
