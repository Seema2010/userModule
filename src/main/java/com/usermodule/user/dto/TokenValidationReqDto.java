package com.usermodule.user.dto;

import com.usermodule.user.constants.ValidationConstants;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TokenValidationReqDto {

    @NotBlank(message = ValidationConstants.INVALID_PASSED_TOKEN)
    private String token;

    @NotBlank(message = ValidationConstants.INVALID_VALIDATION_URL)
    private String reqUrl;
}
