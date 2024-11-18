package com.usermodule.user.repo;

import com.usermodule.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUsername(String username);

    @Query("SELECT c.username FROM user_info c WHERE c.username like %:name% order by c.username")
    public List<String> findByUserNames(@Param("name")String searchParam);
}
