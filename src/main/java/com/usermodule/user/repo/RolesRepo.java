package com.usermodule.user.repo;

import com.usermodule.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolesRepo extends JpaRepository<Role, Integer> {
    Role findById(int id);
    @Query("SELECT roleName FROM role WHERE id = ?1")
    List<String> findRoleNameById(int id);
}
