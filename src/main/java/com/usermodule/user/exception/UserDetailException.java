package com.usermodule.user.exception;

import com.usermodule.user.error.ErrorCode;

public class UserDetailException extends AuthServerException{
    public UserDetailException(String message, ErrorCode errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    public UserDetailException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
