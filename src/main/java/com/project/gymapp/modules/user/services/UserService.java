package com.project.gymapp.modules.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.user.models.User;
import com.project.gymapp.modules.user.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> usersList = userRepository.findAll();
        return usersList.isEmpty() ? usersList : usersList;
    }

    public List<User> findByName(String name) {
        List<User> userList = userRepository.findByName(name);
        return userList.isEmpty() ? userList : userList;
    }

    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

}
