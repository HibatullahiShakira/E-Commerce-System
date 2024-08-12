package com.semicolon.dto.request;

import com.semicolon.data.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeleteProductRequest {
    private UserRole userRole;
    private String product_id;
}
