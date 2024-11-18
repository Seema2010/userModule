package com.usermodule.user.business.impl;

import com.usermodule.user.business.UserRequestBusiness;
import com.usermodule.user.constants.MessageConstants;
import com.usermodule.user.dto.UserDto;
import com.usermodule.user.entity.Role;
import com.usermodule.user.entity.User;
import com.usermodule.user.service.RolesService;
import com.usermodule.user.service.RolesUserService;
import com.usermodule.user.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRequestBusinessImpl implements UserRequestBusiness {
    private final UserService userService;
    private final RolesUserService rolesUserService;
    private final RolesService rolesService;

    @Autowired
    public UserRequestBusinessImpl(UserService userService,
                                   RolesUserService rolesUserService, RolesService rolesService) {
        this.userService = userService;
        this.rolesUserService = rolesUserService;
        this.rolesService = rolesService;
    }

    private static final Logger LOG = LogManager.getLogger(UserRequestBusinessImpl.class);

    public String createUser(UserDto userDetails) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "createUser");
        User user = processCreateUser(userDetails);
        if(user == null) {
            return "Error in creating User";
        }
        return "USER CREATION SUCCESS";
    }

    private User processCreateUser(UserDto userDetails) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "processCreateUser");
        User user = userService.generateUserDetails(userDetails);
        List<Role> roles;
        try {
            roles = findRolesProvided(userDetails.getRole());
        } catch (RoleNotFoundException e) {
            LOG.debug("Error while creating User with Error: {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        rolesUserService.prepareRoleUser(user, roles);
        commitDetailsInDB(user);
        return user;
    }

    private List<Role> findRolesProvided(List<Integer> roleList) throws RoleNotFoundException {
        LOG.debug(MessageConstants.INSIDE_METHOD, "findRolesProvided");
        if(roleList.isEmpty())
            throw new RoleNotFoundException("No Role Provided for this User!!");
        List<Role> roleDetailList = new ArrayList<>();
        for(int role: roleList) {
            Role roleData = rolesService.findById(role);
            if(roleData == null)
                throw new RoleNotFoundException("No Role Found with this ID!!");
            roleDetailList.add(roleData);
        }
        return roleDetailList;
    }

    public void commitDetailsInDB(User user) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "commitDetailsInDB");
        try {
            userService.save(user);
        } catch (Exception ex) {
            LOG.debug(MessageConstants.INSIDE_METHOD, "commitDetailsInDB");
            throw new RuntimeException("Error saving user and role");
        }
    }
}