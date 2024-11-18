package com.usermodule.user.service;

import com.usermodule.user.constants.MessageConstants;
import com.usermodule.user.entity.RoleUser;
import com.usermodule.user.entity.User;
import com.usermodule.user.repo.RolesRepo;
import com.usermodule.user.security.helpers.JwtTokenHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthenticationService {
    private static final Logger LOG = LogManager.getLogger(AuthenticationService.class);

    @Autowired
    public AuthenticationService(JwtTokenHelper jwtTokenHelper, RolesRepo roleRepo) {
        this.jwtTokenHelper = jwtTokenHelper;
        this.rolesRepo = roleRepo;
    }

    private final JwtTokenHelper jwtTokenHelper;

    private final RolesRepo rolesRepo;

    public String generateAPIResponse() {
        LOG.debug(MessageConstants.INSIDE_METHOD, "generateAPIResponse");
        User userDetails = getUserDetails();
        Map<String, Object> claims = generateClaims(userDetails);
        return jwtTokenHelper.generateToken(userDetails, claims);
    }

    private Map<String, Object> generateClaims(User userDetails) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "generateClaims");
        Map<String, Object> claims = new HashMap<>();
        List<String> roleNameList = getRoleNameForUser(userDetails.getRoleUser());
        claims.put(MessageConstants.USER_ROLES, roleNameList);
        return claims;
    }

    private List<String> getRoleNameForUser(List<RoleUser> roles) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getRoleNameForUser");
        List<String> roleNameList = new ArrayList<>();
        for(RoleUser roleUser: roles) {
            roleNameList.addAll(rolesRepo.findRoleNameById(roleUser.getRole().getId()));
        }
        return roleNameList;
    }

    public User getUserDetails() {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getUserDetails");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}
