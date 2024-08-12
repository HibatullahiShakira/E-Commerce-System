package com.semicolon.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class User {
    @Id
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
