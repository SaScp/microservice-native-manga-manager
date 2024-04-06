package ru.alex.userservice.service;

import ru.alex.userservice.model.User;

import java.util.Optional;

public interface UserService {

    User createUser(User user);

    User findByEmail(String email);

    User findById(String id);
}
