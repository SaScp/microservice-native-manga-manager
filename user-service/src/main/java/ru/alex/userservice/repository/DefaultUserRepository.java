package ru.alex.userservice.repository;

import org.springframework.stereotype.Repository;
import ru.alex.userservice.dao.UserDao;
import ru.alex.userservice.model.User;

import java.util.Optional;

@Repository
public class DefaultUserRepository implements UserRepository {

    private UserDao userDao;

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User save(User entity) {
        return userDao.save(entity);
    }


}
