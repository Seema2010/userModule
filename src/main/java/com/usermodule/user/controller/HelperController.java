package com.usermodule.user.controller;

import com.usermodule.user.business.StaticRequestBusiness;
import com.usermodule.user.constants.MessageConstants;
import com.usermodule.user.dto.RoleDto;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/helper")
public class HelperController {
    private static final Logger LOG = LogManager.getLogger(HelperController.class);

    private final StaticRequestBusiness staticRequestService;

    @Autowired
    public HelperController(StaticRequestBusiness staticRequestService) {
        this.staticRequestService = staticRequestService;
    }

    @PostMapping(value = "/roleAdd")
    public ResponseEntity<String> addRole(@Valid @RequestBody RoleDto roleDto) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "addRole");
        String response = staticRequestService.generateAPIResponse(roleDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
