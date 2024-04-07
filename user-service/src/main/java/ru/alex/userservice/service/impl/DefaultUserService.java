package ru.alex.userservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.userservice.dto.UserDto;
import ru.alex.userservice.model.Role;
import ru.alex.userservice.model.User;
import ru.alex.userservice.repository.UserRepository;
import ru.alex.userservice.service.UserService;
import ru.alex.userservice.util.exception.SavingUserException;
import ru.alex.userservice.util.exception.UserNotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DefaultUserService implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(UserDto entity) {
        return userRepository.save(User.builder()
                        .id(UUID.randomUUID().toString())
                        .username(entity.getUsername())
                        .email(entity.getEmail())
                        .fullName(entity.getFullName())
                        .password(entity.getPassword())
                        .dateOfBirth(entity.getDateOfBirth())
                        .registrationDate(LocalDateTime.now())
                        .role(Role.ROLE_USER.name()).build()
                ).orElseThrow(SavingUserException::new);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UserNotFoundException(email));
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id));
    }

    @Override
    public boolean update(UserDto userDto, String id) {
        return false;
    }

}
