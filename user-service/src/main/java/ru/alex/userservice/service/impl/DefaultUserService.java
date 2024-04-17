package ru.alex.userservice.service.impl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.userservice.dto.UserDto;
import ru.alex.userservice.model.Role;
import ru.alex.userservice.model.User;
import ru.alex.userservice.repository.UserRepository;
import ru.alex.userservice.service.UserService;
import ru.alex.userservice.util.exception.UserNotFoundException;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DefaultUserService implements UserService {

    private static final Logger log = LoggerFactory.getLogger(DefaultUserService.class);
    private UserRepository userRepository;

    @Transactional
    @Override
    public User createUser(UserDto entity) {
        log.info(String.valueOf(Role.ROLE_USER));
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .password(entity.getPassword())
                .dateOfBirth(LocalDateTime.now())
                .registrationDate(LocalDateTime.now())
                .roles(Set.of(Role.ROLE_USER))
                .build();
        return userRepository.save(user);
    }

    @Override
    @Async
    public CompletableFuture<User> findByEmail(String email) {
        return CompletableFuture.completedFuture(userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email)));
    }

    @Override
    @Async
    public CompletableFuture<User> findById(String id) {
        return CompletableFuture.completedFuture(userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id)));
    }

    @Override
    public boolean update(UserDto userDto, String id) {
        return false;
    }

}
