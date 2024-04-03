package ru.alex.userservice.repository;

import org.springframework.stereotype.Repository;
import ru.alex.userservice.model.User;

import java.util.Optional;


public interface UserRepository {
    Optional<User> findByEmail(String email);

    User save(User entity);
}
