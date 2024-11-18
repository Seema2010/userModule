package com.usermodule.user.repo;

import com.usermodule.user.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesUserRepo extends JpaRepository<RoleUser, Integer> {

    RoleUser findById(int id);
}
