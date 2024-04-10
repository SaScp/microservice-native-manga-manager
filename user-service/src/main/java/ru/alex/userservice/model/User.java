package ru.alex.userservice.model;

import jakarta.persistence.*;
import lombok.*;


import ru.alex.userservice.dto.UserDto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "user_microservice", name = "t_user")
public class User {

    @Id
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "role_id")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "t_role_t_user", schema = "user_microservice")
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Collection> collections;

    public void addRole(Role role) {
        roles.add(role);
    }

    public void addCollection(Collection collection) {
        collections.add(collection);
    }
}
