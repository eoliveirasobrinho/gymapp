package com.project.gymapp.modules.user.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.gymapp.modules.user.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
