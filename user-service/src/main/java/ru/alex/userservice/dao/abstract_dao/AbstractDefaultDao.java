package ru.alex.userservice.dao.abstract_dao;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDefaultDao<T> implements CrudDao<T> {
    protected JdbcTemplate jdbcTemplate;

    public AbstractDefaultDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int update(T entity) {
        return 0;
    }
}
