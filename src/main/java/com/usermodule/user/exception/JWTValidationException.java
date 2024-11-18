package com.usermodule.user.exception;

import com.usermodule.user.error.ErrorCode;

public class JWTValidationException extends AuthServerException{

    public JWTValidationException(String message, ErrorCode errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    public JWTValidationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
