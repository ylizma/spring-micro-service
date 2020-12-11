package com.ylizma.userservice.repositories;

import com.ylizma.userservice.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    UserApp findByUsername(String username);
}
