package ru.alex.userservice.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alex.userservice.SQL.UserRoleSQLConstant;
import ru.alex.userservice.dao.abstract_dao.AbstractDefaultDao;
import ru.alex.userservice.model.UserRole;

import java.util.Optional;

@Slf4j
@Component
public class UserRoleDao extends AbstractDefaultDao<UserRole> {

    public UserRoleDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Optional<UserRole> save(UserRole entity) {
        if (entity == null) {
            return Optional.empty();
        } else if (Optional.ofNullable(entity.getUserId()).isEmpty() ||
                Optional.ofNullable(entity.getRoleId()).isEmpty()) {
            log.error("user_id or role_id is null");
            return Optional.empty();
        }
        this.jdbcTemplate.update(UserRoleSQLConstant.SAVE_USER_ROLE_QUERY, entity.getUserId(), entity.getRoleId());
        return Optional.ofNullable(entity);
    }

    @Override
    public int delete(Long id) {
        if (Optional.ofNullable(id).isEmpty()) {
            log.error("id is null");
            return 0;
        }
        log.info("delete user_role with user_id successful");
        return this.jdbcTemplate.update(UserRoleSQLConstant.DELETE_USER_ROLE_BY_USER_ID_QUERY, id);
    }

    public int deleteByRoleId(Long id) {
        if (Optional.ofNullable(id).isEmpty()) {
            log.error("id is null");
            return 0;
        }
        log.info("delete user_role with role_id successful");
        return this.jdbcTemplate.update(UserRoleSQLConstant.DELETE_USER_ROLE_BY_ROLE_ID_QUERY, id);
    }

    @Override
    public Optional<UserRole> findById(Long id) {

        return Optional.empty();
    }
}
