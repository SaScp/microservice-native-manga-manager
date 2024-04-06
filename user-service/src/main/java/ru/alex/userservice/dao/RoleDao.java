package ru.alex.userservice.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.alex.userservice.dao.abstract_dao.AbstractDefaultDao;
import ru.alex.userservice.model.Role;

import java.util.Optional;

public class RoleDao extends AbstractDefaultDao<Role> {

    public RoleDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Optional<Role> save(Role entity) {
        return Optional.empty();
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.empty();
    }

}
