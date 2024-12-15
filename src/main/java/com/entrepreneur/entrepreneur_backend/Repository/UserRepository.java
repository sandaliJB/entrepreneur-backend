package com.entrepreneur.entrepreneur_backend.Repository;

import com.entrepreneur.entrepreneur_backend.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserId(String userId);
    User findByUserEmail(String username);
    @Query("SELECT u.username FROM User u WHERE u.id = :userId")
    Optional<User> findUsernameByUserId(String userId);
}
