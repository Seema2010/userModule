package com.usermodule.user.error;

public enum ErrorCode {

    SUCCESS("200"),
    EMAIL_ERROR("4001"),
    USER_DATA_ERROR("4002"),
    DATA_INTEGRITY_VIOLATION("4003"),
    APP_REG_ERROR("4005"),
    JWT_VALIDATION_ERROR("4006"),
    INVALID_ERROR("4000");

    public final String value;

    ErrorCode(String value) {
        this.value = value;
    }
}
