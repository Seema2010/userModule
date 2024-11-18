package com.usermodule.user.service;

import com.usermodule.user.constants.MessageConstants;
import com.usermodule.user.entity.Role;
import com.usermodule.user.repo.RolesRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    private static final Logger LOG = LogManager.getLogger(RolesService.class);

    @Autowired
    public RolesService(RolesRepo rolesRepo) {
        this.rolesRepo = rolesRepo;
    }

    private final RolesRepo rolesRepo;

    public Role findById(int id) {
        return this.rolesRepo.findById(id);
    }
    public Role save(Role roleDetails) {
        return this.rolesRepo.save(roleDetails);
    }

    public Role createRole(String roleName, String roleCode, String roleDes) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "createRole");
        Role role = new Role();
        role.setRoleCode(roleCode);
        role.setRoleName(roleName);
        role.setRoleDescription(roleDes);
        save(role);
        return role;
    }
}
