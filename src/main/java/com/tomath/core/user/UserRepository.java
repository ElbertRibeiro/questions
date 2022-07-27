package com.tomath.core.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findByNameUser(String nameUser);
    User findUserByEmail(String email);
    User findUserById(String id);
}
