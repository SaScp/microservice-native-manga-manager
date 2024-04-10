package ru.alex.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.alex.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {



}
