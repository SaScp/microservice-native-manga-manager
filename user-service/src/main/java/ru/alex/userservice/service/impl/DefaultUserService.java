package ru.alex.userservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.userservice.model.User;
import ru.alex.userservice.repository.UserRepository;
import ru.alex.userservice.service.UserService;
import ru.alex.userservice.util.exception.SavingUserException;
import ru.alex.userservice.util.exception.UserNotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DefaultUserService implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user).orElseThrow(() -> new SavingUserException());
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

}
