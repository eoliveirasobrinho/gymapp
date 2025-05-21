package com.project.gymapp.modules.user.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.user.models.User;
import com.project.gymapp.modules.user.models.dtos.UserDTO;
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

    public List<User> findUserByName(String name) {
        List<User> userList = userRepository.findUserByName(name);
        return userList.isEmpty() ? userList : userList;
    }

    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        return user;
    }

    public User createUser(UserDTO userDTO) throws Exception {

        Optional<User> userFounded = userRepository.findUserByEmail(userDTO.email());

        if (userDTO == null) {
            throw new Exception("This user cannot be empty! Please create one");
        }
        if (userFounded.isPresent()) {
            throw new Exception("Usuário encontrado com este email! " + userFounded);
        }
        String userId = UUID.randomUUID().toString();
        User user = new User(userId, userDTO.document(), userDTO.email(), userDTO.lastName(), userDTO.name(), userDTO.documentType(), userDTO.address(), userDTO.isActive());
        User userSaved = userRepository.save(user);
        return userSaved;
    }

}
