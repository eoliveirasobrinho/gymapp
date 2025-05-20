package com.project.gymapp.modules.user.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.gymapp.modules.user.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    public List<User> findByName(String name);

    public User findByEmail(String email);
}
