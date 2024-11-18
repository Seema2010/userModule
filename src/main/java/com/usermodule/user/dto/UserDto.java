package com.usermodule.user.dto;

import com.usermodule.user.constants.ValidationConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class UserDto {

    @NotBlank(message = ValidationConstants.INVALID_USER_EMAIL)
    @Email
    private String email;

    @NotBlank(message = ValidationConstants.INVALID_USER_PASSWORD)
    private String password;

    @NotNull(message = ValidationConstants.INVALID_USER_ROLE)
    private List<Integer> role;
}
