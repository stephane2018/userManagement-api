package com.stephane.userservice.repository;

import com.stephane.userservice.models.Role;
import com.stephane.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
