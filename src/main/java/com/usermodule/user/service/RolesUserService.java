package com.usermodule.user.service;

import com.usermodule.user.constants.MessageConstants;
import com.usermodule.user.entity.Role;
import com.usermodule.user.entity.RoleUser;
import com.usermodule.user.entity.User;
import com.usermodule.user.repo.RolesUserRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesUserService {

    @Autowired
    public RolesUserService(RolesUserRepo rolesUserRepo) {
        this.rolesUserRepo = rolesUserRepo;
    }

    private final RolesUserRepo rolesUserRepo;

    private static final Logger LOG = LogManager.getLogger(RolesUserService.class);

    public RoleUser findById(int id) {
        return this.rolesUserRepo.findById(id);
    }
    public RoleUser save(RoleUser roleUser) {
        return this.rolesUserRepo.save(roleUser);
    }

    public void prepareRoleUser(User userDm, List<Role> roles) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "prepareRoleUser");
        List<RoleUser> roleUserList = new ArrayList<>();
        for(Role role: roles) {
            RoleUser roleUser = new RoleUser();
            roleUser.setRole(role);
            roleUser.setUser(userDm);
            roleUserList.add(roleUser);
        }
        userDm.setRoleUser(roleUserList);
    }
}
