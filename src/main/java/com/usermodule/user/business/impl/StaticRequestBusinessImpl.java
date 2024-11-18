package com.usermodule.user.business.impl;

import com.usermodule.user.business.StaticRequestBusiness;
import com.usermodule.user.constants.MessageConstants;
import com.usermodule.user.dto.RoleDto;
import com.usermodule.user.entity.Role;
import com.usermodule.user.service.RolesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaticRequestBusinessImpl implements StaticRequestBusiness {

    @Autowired
    public StaticRequestBusinessImpl(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    private final RolesService rolesService;

    private static final Logger LOG = LogManager.getLogger(StaticRequestBusinessImpl.class);

    @Override
    public String generateAPIResponse(RoleDto roleDto) {
        LOG.info(MessageConstants.INSIDE_METHOD, "generateAPIResponse");
        Role roleVal = rolesService.createRole(roleDto.getRoleName(), roleDto.getRoleCode(),
                roleDto.getRoleDescription());
        if(roleVal == null) {
            return "ERROR_ROLE_CREATE";
        }
        return "SUCCESS_ROLE_CREATE";
    }
}
