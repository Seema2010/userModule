package com.usermodule.user.module.service;

import com.usermodule.user.module.dto.UserDto;
import com.usermodule.user.module.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
