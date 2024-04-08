package ru.alex.userservice.dao.abstract_dao;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDefaultDao<T, ID> implements DefaultDao<T, ID>, FindByIdDao<T, ID> {
    protected JdbcTemplate jdbcTemplate;

    public AbstractDefaultDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
