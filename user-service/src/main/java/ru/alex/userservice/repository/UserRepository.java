package ru.alex.userservice.repository;

import ru.alex.userservice.model.User;

import java.util.Optional;


public interface UserRepository {
    Optional<User> findByEmail(String email);

    Optional<User> save(User entity);

    Optional<User> findById(String id);
}
