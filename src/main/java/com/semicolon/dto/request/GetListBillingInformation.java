package com.semicolon.dto.request;

import com.semicolon.data.model.BillingInformation;
import com.semicolon.data.model.User;
import com.semicolon.data.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class GetListBillingInformation {
    private UserRole userRole;
    private User user;
}
