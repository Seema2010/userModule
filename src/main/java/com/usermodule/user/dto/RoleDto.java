package com.usermodule.user.dto;

import com.usermodule.user.constants.ValidationConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoleDto {
    @NotBlank(message = ValidationConstants.INVALID_ROLE_CODE)
    @Size(max = 2, message = ValidationConstants.INVALID_ROLE_SIZE)
    private String roleCode;

    @NotBlank(message = ValidationConstants.INVALID_ROLE_NAME)
    private String roleName;

    private String roleDescription;
}
