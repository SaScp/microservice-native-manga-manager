package ru.alex.userservice.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> {


    protected JdbcTemplate jdbcTemplate;

    public AbstractDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public abstract T save(T entity);

    public abstract int update(T entity);

    public abstract Optional<List<T>> findAll();

    public abstract int delete(int id);

    public abstract T findById(int id);
}