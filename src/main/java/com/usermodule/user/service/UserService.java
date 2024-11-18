package com.usermodule.user.service;

import com.usermodule.user.constants.MessageConstants;
import com.usermodule.user.dto.UserDto;
import com.usermodule.user.entity.User;
import com.usermodule.user.repo.UserRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    private static final Logger LOG = LogManager.getLogger(UserService.class);
    public User save(User user) {
        return this.userRepo.save(user);
    }

    public User findUserByUserName(String userName) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "findUserByUserName");
        User user = userRepo.findByUsername(userName);
        if(user != null)
            return user;
        throw new UsernameNotFoundException("Username not found: " + userName);
    }

    public User generateUserDetails(UserDto userDetails) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "generateUserDetails");
        User user = new User();
        user.setUsername(generateUserName(userDetails.getEmail()));
        user.setPassword(BCrypt.hashpw(userDetails.getPassword(), BCrypt.gensalt()));
        return user;
    }

    private String generateUserName(String email) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "generateUserName");
        String userId = email.split("@")[0];
        userId = userId.replaceAll("[-+.^:,]","");
        String userName = generateUserNameFromString(userId);
        return checkIfPresent(userName);
    }

    private String checkIfPresent(String userName) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "checkIfPresent");
        String detailsInDB = getLastestUserName(userName + "%");
        if(detailsInDB.equalsIgnoreCase("")) {
            return userName + "1";
        } else {
            int val = Integer.parseInt(detailsInDB.substring(7));
            val++;
            return detailsInDB.substring(0, 7) + val;
        }
    }

    private String generateUserNameFromString(String userId) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "generateUserNameFromString");
        int size = userId.length();
        if(size > 7) {
            return userId.substring(0, 7);
        } else {
            return RandomStringUtils.randomAlphanumeric(7);
        }
    }

    private String getLastestUserName(String userSearchParam) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getLastestUserName");
        List<String> result = this.userRepo.findByUserNames(userSearchParam);
        if(result.isEmpty())
            return "";
        else {
            int size = result.size();
            return result.get(size-1);
        }
    }
}
