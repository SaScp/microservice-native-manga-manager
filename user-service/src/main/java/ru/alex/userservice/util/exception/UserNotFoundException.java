package ru.alex.userservice.util.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super("User with " + message + " not found!");
    }
}
