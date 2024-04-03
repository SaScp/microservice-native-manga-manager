package ru.alex.userservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private String email;

    private String username;

    private String fullName;

    private LocalDateTime dateOfBirth;
}
