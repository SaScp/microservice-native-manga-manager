package ru.alex.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @Email(groups = {Created.class})
    private String email;

    @NotNull(groups = {Created.class})
    private String username;

    @NotNull(groups = {Created.class})
    private String fullName;

    @NotNull(groups = {Created.class})
    private LocalDateTime dateOfBirth;

    @NotNull(groups = {Created.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String newPassword;
}
