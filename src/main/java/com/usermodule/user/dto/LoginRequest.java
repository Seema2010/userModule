package com.usermodule.user.dto;

import com.usermodule.user.constants.ValidationConstants;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = ValidationConstants.INVALID_USER_USERNAME)
    private String userName;
    @NotBlank(message = ValidationConstants.INVALID_USER_PASSWORD)
    private String password;
}
