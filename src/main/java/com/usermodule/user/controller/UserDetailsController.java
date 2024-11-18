package com.usermodule.user.controller;

import com.usermodule.user.business.LoginRequestBusiness;
import com.usermodule.user.business.UserRequestBusiness;
import com.usermodule.user.constants.MessageConstants;
import com.usermodule.user.dto.UserDto;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserDetailsController {
        private static final Logger LOG = LogManager.getLogger(UserDetailsController.class);

        private final UserRequestBusiness userRequestBusiness;

        private final LoginRequestBusiness loginRequestBusiness;

        @Autowired
        public UserDetailsController(UserRequestBusiness userRequestBusiness, LoginRequestBusiness loginRequestBusiness) {
            this.userRequestBusiness = userRequestBusiness;
            this.loginRequestBusiness = loginRequestBusiness;
        }

        @Validated
        @PostMapping(value = "/signup")
        public ResponseEntity<String> saveUser(@Valid @RequestBody UserDto userDetails) {
            LOG.debug(MessageConstants.INSIDE_METHOD, "saveUser");
            String response = userRequestBusiness.createUser(userDetails);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    @GetMapping(value = "/login")
    public ResponseEntity<String> validateUser() {
        LOG.debug(MessageConstants.INSIDE_METHOD, "validateUser");
        String response = loginRequestBusiness.generateAPIResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


