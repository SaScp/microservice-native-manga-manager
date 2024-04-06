package ru.alex.userservice.repository;

import org.springframework.stereotype.Repository;
import ru.alex.userservice.dao.UserDao;
import ru.alex.userservice.model.User;

import java.util.Optional;

@Repository
public class DefaultUserRepository implements UserRepository {

    private UserDao userDao;

    public DefaultUserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Optional<User> save(User entity) {
        return userDao.save(entity);
    }

    @Override
    public Optional<User> findById(String id) {
        return userDao.findById(id);
    }


}
