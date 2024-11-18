package com.usermodule.user.exception;

import com.usermodule.user.error.ErrorCode;

public class AuthServerException extends RuntimeException {

    private final ErrorCode errorCode;

    public AuthServerException(String arg0, ErrorCode errorCode) {
        super(arg0);
        this.errorCode = errorCode;
    }

    protected AuthServerException(String arg0, ErrorCode errorCode, Throwable cause) {
        super(arg0, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
