package com.ylizma.userservice.repositories;

import com.ylizma.userservice.entities.RoleApp;
import com.ylizma.userservice.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface RoleAppRepository extends JpaRepository<RoleApp,Long> {
    RoleApp findByName(String name);
}
