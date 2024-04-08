package ru.alex.userservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import ru.alex.userservice.dto.UserDto;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(value = "c_role")
    private String role;

}
