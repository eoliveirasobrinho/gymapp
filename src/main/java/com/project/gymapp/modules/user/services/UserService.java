package com.project.gymapp.modules.user.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.user.infrastructure.security.SecurityConfigurations;
import com.project.gymapp.modules.user.models.User;
import com.project.gymapp.modules.user.models.dtos.UserDTO;
import com.project.gymapp.modules.user.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    SecurityConfigurations securityConfigurations;

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
            throw new Exception("User founded! Use another email");
        }

        String userPassword = userDTO.password();
        String encodedPassString = this.securityConfigurations.passwordEncoder().encode(userPassword);
        String id = UUID.randomUUID().toString();
        User user = new User(id, userDTO.document(), userDTO.email(), userDTO.lastName(), userDTO.name(), userDTO.documentType(), userDTO.address(), userDTO.isActive(), userDTO.username(), encodedPassString, userDTO.role());
        User userSaved = userRepository.save(user);
        return userSaved;
    }

    public User updateUser(UserDTO userDTO, String email) {
        Optional<User> user = userRepository.findUserByEmail(email);

        if (user.isPresent()) {
            if (userDTO.document() != null && !userDTO.document().equals(user.get().getDocument())) {
                user.get().setDocument(userDTO.document());
            }
            if (userDTO.email() != null && !userDTO.email().equals(user.get().getEmail())) {
                user.get().setEmail(userDTO.email());
            }
            if (userDTO.isActive() != null && !userDTO.isActive().equals(user.get().getIsActive())) {
                user.get().setIsActive(userDTO.isActive());
            }
            if (userDTO.address() != null && !userDTO.address().equals(user.get().getAddress())) {
                user.get().setAddress(userDTO.address());
            }

            if (userDTO.name() != null && !userDTO.name().equals(user.get().getName())) {
                user.get().setName(userDTO.name());
            }

            if (userDTO.lastName() != null && !userDTO.lastName().equals(user.get().getLastName())) {
                user.get().setLastName(userDTO.lastName());
            }

            if (userDTO.documentType() != null && !userDTO.documentType().equals(user.get().getType())) {
                user.get().setType(userDTO.documentType());
            }
        }
        User userToUpdate = user.get();
        User userSaved = userRepository.save(userToUpdate);
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
