package ru.alex.userservice.model;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    private String id;

    private String email;

    private String password;

    private String username;

    @Column(value = "full_name")
    private String fullName;

    @Column(value = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(value = "registration_date")
    private LocalDateTime registrationDate;

    private Character sex;

}
