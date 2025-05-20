package com.project.gymapp.modules.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.gymapp.modules.user.models.User;
import com.project.gymapp.modules.user.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    public String health() {
        return "OK";
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        List<User> usersList = userService.findAll();
        return usersList.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(usersList) : ResponseEntity.status(HttpStatus.OK).body(usersList);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<User>> findByName(@PathVariable @Valid String name) {
        List<User> userList = userService.findByName(name);
        return userList.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(userList) : ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/email")
    public ResponseEntity<Object> findByEmail(@PathVariable @Valid String email) {
        User user = userService.findByEmail(email);
        return user.getEmail().isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(user) : ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
