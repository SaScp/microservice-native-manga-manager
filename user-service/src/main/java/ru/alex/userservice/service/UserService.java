package ru.alex.userservice.service;

import ru.alex.userservice.model.User;

import java.util.Optional;

public interface UserService {
    User findByEmail(String email);

    User findById(String id);
}
