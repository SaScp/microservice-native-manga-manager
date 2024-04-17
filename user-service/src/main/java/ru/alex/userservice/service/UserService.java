package ru.alex.userservice.service;

import ru.alex.userservice.dto.UserDto;
import ru.alex.userservice.model.User;

import java.util.concurrent.CompletableFuture;

public interface UserService {

    User createUser(UserDto entity);

    CompletableFuture<User> findByEmail(String email);

    CompletableFuture<User> findById(String id);

    boolean update(UserDto userDto, String id);
}
