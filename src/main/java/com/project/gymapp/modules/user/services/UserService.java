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

    public User findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user;
    }

    public User createUser(UserDTO userDTO) throws Exception {

        User userFounded = userRepository.findUserByEmail(userDTO.email());

        if (userDTO == null) {
            throw new Exception("This user cannot be empty! Please create one");
        }
        if (userFounded.getEmail() == userDTO.email()) {
            throw new Exception("Usuário encontrado com este email! " + userFounded);
        }
        String id = UUID.randomUUID().toString();
        User user = new User(id, userDTO.document(), userDTO.email(), userDTO.lastName(), userDTO.name(), userDTO.documentType(), userDTO.address(), userDTO.isActive());
        User userSaved = userRepository.save(user);
        return userSaved;
    }

    public User updateUser(UserDTO userDTO, String email) {
        User user = userRepository.findUserByEmail(email);

        if (userDTO.document() != null && !userDTO.document().equals(user.getDocument())) {
            user.setDocument(userDTO.document());
        }
        if (userDTO.email() != null && !userDTO.email().equals(user.getEmail())) {
            user.setEmail(userDTO.email());
        }
        if (userDTO.isActive() != null && !userDTO.isActive().equals(user.getIsActive())) {
            user.setIsActive(userDTO.isActive());
        }
        if (userDTO.address() != null && !userDTO.address().equals(user.getAddress())) {
            user.setAddress(userDTO.address());
        }

        if (userDTO.name() != null && !userDTO.name().equals(user.getName())) {
            user.setName(userDTO.name());
        }

        if (userDTO.lastName() != null && !userDTO.lastName().equals(user.getLastName())) {
            user.setLastName(userDTO.lastName());
        }

        if (userDTO.documentType() != null && !userDTO.documentType().equals(user.getType())) {
            user.setType(userDTO.documentType());
        }

        User userSaved = userRepository.save(user);
        return userSaved;
    }

    public void deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);
        User userToDelete = user.get();
        userRepository.delete(userToDelete);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

}
