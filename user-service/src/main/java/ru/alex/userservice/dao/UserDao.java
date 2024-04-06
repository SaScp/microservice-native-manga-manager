package ru.alex.userservice.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.alex.userservice.SQL.UserSQLConstant;
import ru.alex.userservice.dao.abstract_dao.AbstractDefaultDao;
import ru.alex.userservice.dao.abstract_dao.FindAllDao;
import ru.alex.userservice.dao.abstract_dao.FindByIdDao;
import ru.alex.userservice.model.User;
import ru.alex.userservice.util.exception.UserNotFoundException;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@Slf4j
public class UserDao extends AbstractDefaultDao<User, String> implements FindAllDao<User> {

    public UserDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public Optional<User> save(User entity) {

        if (Optional.ofNullable(entity).isEmpty()) {
            log.error("entity is null");
            return Optional.empty();
        }

        this.jdbcTemplate.update(UserSQLConstant.SAVE_USER_QUERY,
                entity.getId(), entity.getEmail(), entity.getPassword(), entity.getUsername(),
                entity.getFullName(), entity.getDateOfBirth(), entity.getRegistrationDate(), entity.getRole());

        log.info("save: {}", entity.getId());
        return Optional.ofNullable(entity);
    }

    @Override
    public int update(User entity) {
        if (entity.getEmail() == null && entity.getId() == null) {
            log.error("an id or email must be present");
            return 0;
        }
        int paramIndex = 1;
        Field[] fields = entity.getClass().getDeclaredFields();
        List<Object> params = new ArrayList<>();
        StringBuilder sql = generateUpdateDataForQuery(fields, params, entity);

        if (UserSQLConstant.BEGIN_UPDATE_USER_QUERY.length() == sql.toString().length()) {
            log.error("there are no updated elements in the request");
            return 0;
        }
        sql.append(UserSQLConstant.END_UPDATE_USER_QUERY);

        return this.jdbcTemplate.update(sql.toString(), params);

    }

    @Override
    public Optional<List<User>> findAll() {
        return Optional.of(this.jdbcTemplate.query(UserSQLConstant.SELECT_USER_QUERY,
                new BeanPropertyRowMapper<>(User.class)));
    }

    @Override
    public int delete(String id) {
        if (Optional.ofNullable(id).isEmpty()) {
            log.error("id must be present");
            return 0;
        }
        return this.jdbcTemplate.update(UserSQLConstant.DELETE_USER_QUERY, id);
    }

    @Override
    public Optional<User> findById(String id) {
        if (Optional.ofNullable(id).isEmpty()) {
            log.error("id must be present!");
            return Optional.empty();
        }

        try {
            return Optional.ofNullable(this.jdbcTemplate
                    .queryForObject(UserSQLConstant.SELECT_BY_ID_USER_QUERY,
                            new BeanPropertyRowMapper<>(User.class), id));
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException(id);
        }
    }

    public Optional<User> findByEmail(String email) {

        if (Optional.ofNullable(email).isEmpty()) {
            log.error("email must be present!");
            return Optional.empty();
        }
        try {
            return Optional.ofNullable(this.jdbcTemplate
                    .queryForObject(UserSQLConstant.SELECT_BY_EMAIL_QUERY,
                            new BeanPropertyRowMapper<>(User.class), email));
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException(email);
        }
    }

    private StringBuilder generateUpdateDataForQuery(Field[] fields, List<Object> params, User entity) {
        StringBuilder sql = new StringBuilder(UserSQLConstant.BEGIN_UPDATE_USER_QUERY);
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            if (Optional.ofNullable(ReflectionUtils.getField(fields[i], entity)).isPresent()) {
                if (!fields[i].getName().equals("id") && !fields[i].getName().equals("email")) {
                    if (fields[i].isAnnotationPresent(Column.class)) {
                        sql.append(fields[i].getAnnotation(Column.class).value()).append(i + 1 < fields.length ? "=?," : " ");
                    } else {
                        sql.append(fields[i].getName()).append(i + 1 < fields.length ? "=?," : " ");
                    }
                    params.add(ReflectionUtils.getField(fields[i], entity));
                }
            }
        }
        return sql;
    }


}

