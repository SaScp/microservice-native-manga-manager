package ru.alex.userservice.service;

import ru.alex.userservice.dto.UserDto;
import ru.alex.userservice.model.User;

import java.util.Optional;

public interface UserService {

    User createUser(UserDto entity);

    User findByEmail(String email);

    User findById(String id);

    boolean update(UserDto userDto, String id);
}
