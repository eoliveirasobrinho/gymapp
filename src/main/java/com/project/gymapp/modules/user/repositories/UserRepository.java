package com.project.gymapp.modules.user.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.project.gymapp.modules.user.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    public List<User> findUserByName(String name);

    public Optional<User> findUserByEmail(String email);

    public UserDetails findByUsername(String userName);

}
