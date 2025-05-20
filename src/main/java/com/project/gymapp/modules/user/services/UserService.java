package com.project.gymapp.modules.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.user.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

}
