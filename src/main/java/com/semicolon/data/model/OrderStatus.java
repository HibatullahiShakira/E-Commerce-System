package com.semicolon.data.model;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PENDING,
    SUCCESSFUL,
    FAILED,
    CANCELLED,
}
