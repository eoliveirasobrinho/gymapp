package com.project.gymapp.modules.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.gymapp.modules.user.models.User;
import com.project.gymapp.modules.user.models.dtos.UserDTO;
import com.project.gymapp.modules.user.repositories.UserRepository;
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

    @GetMapping("/name/{name}")
    public ResponseEntity<List<User>> findByName(@PathVariable String name) {
        List<User> userList = userService.findUserByName(name);
        return userList.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(userList) : ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/mail/{email}")
    public ResponseEntity<Object> findByEmail(@PathVariable String email) {
        User user = userService.findUserByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO userDTO) throws Exception {
        User user = userService.createUser(userDTO);
        return user.getEmail().isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user) : ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PatchMapping("/update/{email}")
    public ResponseEntity<Object> updateUser(@RequestBody @Valid UserDTO userDto, @PathVariable String email) {
        User user = userService.updateUser(userDto, email);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @DeleteMapping("/delete/all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        userService.deleteAll();
    }
}
