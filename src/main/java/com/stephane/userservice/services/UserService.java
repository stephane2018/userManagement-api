package com.stephane.userservice.services;

import com.stephane.userservice.models.Role;
import com.stephane.userservice.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveROle(Role role);

    void addToleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
