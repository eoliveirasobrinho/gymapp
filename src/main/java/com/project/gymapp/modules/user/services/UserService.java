package com.project.gymapp.modules.user.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.infrastructure.security.configs.SecurityConfigurations;
import com.project.gymapp.modules.user.exceptions.UserAlreadyRegisteredWithEmail;
import com.project.gymapp.modules.user.exceptions.UserNotFoundException;
import com.project.gymapp.modules.user.exceptions.UsersListIsEmptyException;
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
        if (usersList.isEmpty()) {
            throw new UsersListIsEmptyException();
        }
        return usersList;
    }

    public List<User> findUserByName(String name) {
        List<User> userList = userRepository.findUserByName(name);
        if (userList.isEmpty()) {
            throw new UsersListIsEmptyException();
        }
        return userList;
    }

    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        return user;
    }

    public User createUser(UserDTO userDTO) throws Exception {

        Optional<User> userFounded = userRepository.findUserByEmail(userDTO.email());

        if (userDTO == null) {
            throw new Exception("This user cannot be empty! Please create one");
        }
        if (userFounded.isPresent()) {
            throw new UserAlreadyRegisteredWithEmail();
        }

        String userPassword = userDTO.password();
        String encodedPassString = this.securityConfigurations.passwordEncoder().encode(userPassword);
        String id = UUID.randomUUID().toString();
        User user = new User(id, userDTO.document(), userDTO.email(), userDTO.lastName(), userDTO.name(), userDTO.documentType(), userDTO.isActive(), userDTO.username(), encodedPassString, userDTO.role());
        User userSaved = userRepository.save(user);
        return userSaved;
    }

    public User updateUser(UserDTO userDTO, String email) {
        Optional<User> user = userRepository.findUserByEmail(email);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

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
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        User userToDelete = user.get();
        userRepository.delete(userToDelete);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

}
