package com.usermodule.user.business.impl;

import com.usermodule.user.business.LoginRequestBusiness;
import com.usermodule.user.constants.MessageConstants;
import com.usermodule.user.security.JWTAuthorizationFilter;
import com.usermodule.user.security.helpers.JwtTokenHelper;
import com.usermodule.user.service.AuthenticationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginRequestBusinessImpl implements LoginRequestBusiness {

    private static final Logger LOG = LogManager.getLogger(LoginRequestBusinessImpl.class);

    private final AuthenticationService authenticationService;

    private final JwtTokenHelper jwtTokenHelper;

    private final JWTAuthorizationFilter jwtAuthorizationFilter;
   // private final EncryptoUtil encryptoUtil;

    @Autowired
    public LoginRequestBusinessImpl(AuthenticationService authenticationService, JwtTokenHelper
            jwtTokenHelper, JWTAuthorizationFilter jwtAuthorizationFilter) {
        this.authenticationService = authenticationService;
        this.jwtTokenHelper = jwtTokenHelper;
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    //    this.encryptoUtil = encryptoUtil;
    }



//    public String generateToken(String appId, String hmac, AppApiTokenDto appApiTokenDto) {
//        LOG.debug(MessageConstants.INSIDE_METHOD, "generateToken");
//        User userDetails = authenticationService.getUserDetails();
//        String appKey = performAppValidation(appId, hmac, appApiTokenDto.getScopeUrl(), userDetails);
//        return jwtTokenHelper.generateAPIToken(generateClaims(appId,
//                appApiTokenDto.getScopeUrl()), userDetails.getUsername(), appKey);
//    }

    private Map<String, Object> generateClaims(String appId, String apiUrl) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("AppId", appId);
        claims.put("apiUrl", apiUrl);
        return claims;
    }

    /**
     * @return
     */
    @Override
    public String generateAPIResponse() {
        LOG.debug(MessageConstants.INSIDE_METHOD, "generateAPIResponse");
        return authenticationService.generateAPIResponse();
    }

//
//    @Override
//    public ApiResponseWrapper<String> generateAPIResponse(String appId, String hmac, TokenValidationReqDto tokenDto) {
//        LOG.debug(MessageConstants.INSIDE_METHOD, "generateApiResponse");
//        ApiResponseWrapper<String> response = new ApiResponseWrapper<>();
//        String responseString = validateHMacAndToken(appId, hmac, tokenDto);
//        if(responseString.isBlank() || responseString.isEmpty()) {
//            response.setResult(ValidationConstants.FAILURE);
//            response.setMsg(ValidationConstants.TOKEN_VALIDATION_FAILURE);
//            return response;
//        }
//        response.setResult(ValidationConstants.SUCCESS);
//        response.setMsg(ValidationConstants.TOKEN_VALIDATION_SUCCESS);
//        return response;
//    }

}
