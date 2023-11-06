package com.stephane.userservice.services;

import com.stephane.userservice.models.Role;
import com.stephane.userservice.models.User;
import com.stephane.userservice.repository.RoleRepository;
import com.stephane.userservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl  implements UserService{

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    @Override
    public User saveUser(User user) {
        log.info("saving new user to the database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveROle(Role role) {
        log.info("saving new role to  user", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addToleToUser(String username, String roleName) {
        log.info("saving new role to the database", roleName, username);
        User user= userRepo.findByUsername(username);
        Role role= roleRepo.findByname(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("saving new role to the database", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetch all user");
        return userRepo.findAll();
    }
}
