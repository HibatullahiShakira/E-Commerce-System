package com.semicolon.dto.request;

import com.semicolon.data.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DeleteBillingInformationRequest {
    private User user;
}
