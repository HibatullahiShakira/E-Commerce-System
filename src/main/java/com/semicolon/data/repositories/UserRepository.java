package com.semicolon.data.repositories;

import com.semicolon.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    User findUserByEmailAddressAndPassword(String email, String password);
    User findUserByUserId(String id);
    User findUserByEmailAddress(String email);
}
