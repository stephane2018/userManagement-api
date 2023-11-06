package com.stephane.userservice.api;

import com.stephane.userservice.data.RoleToUserForm;
import com.stephane.userservice.models.Role;
import com.stephane.userservice.models.User;
import com.stephane.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {
    private final UserService userservice;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok().body(userservice.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return  ResponseEntity.created(uri).body(userservice.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return  ResponseEntity.created(uri).body(userservice.saveROle(role));
    }
    @PostMapping("/role/addtouser")
    public ResponseEntity<Role> saveRole(@RequestBody RoleToUserForm form){
        userservice.addToleToUse(form.getUsername(), form.getRoleName());
        return  ResponseEntity.ok().build();
    }


}
