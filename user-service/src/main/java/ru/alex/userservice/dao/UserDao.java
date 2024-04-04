package ru.alex.userservice.dao;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.alex.userservice.model.User;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserDao extends AbstractDao<User> {

    public UserDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public User save(User entity) {
        /*TODO create validation data*/
        this.jdbcTemplate.update("INSERT INTO user_microservice.t_user" +
                        "(id, email, password, username, full_name, date_of_birth, registration_date, sex)",
                entity.getId(), entity.getEmail(), entity.getPassword(), entity.getUsername(),
                entity.getFullName(), entity.getDateOfBirth(), entity.getRegistrationDate(), entity.getSex()
        );
        log.info("save: " + entity.getId());
        return entity;
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

        if ("UPDATE user_microservice.t_user SET ".length() == sql.toString().length()) {
            log.error("there are no updated elements in the request");
            return 0;
        }
        sql.append("WHERE id =? or email=?");

        try (PreparedStatement preparedStatement =
                     this.jdbcTemplate.getDataSource().getConnection().prepareStatement(sql.toString())){
            for (var i : params)
                preparedStatement.setObject(paramIndex++, i);

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("error opening connection");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<List<User>> findAll() {
        return Optional.of(this.jdbcTemplate.query("SELECT * FROM user_microservice.t_user", new BeanPropertyRowMapper<>(User.class)));
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    private StringBuilder generateUpdateDataForQuery(Field[] fields, List<Object> params, User entity) {
        StringBuilder sql = new StringBuilder("UPDATE user_microservice.t_user SET ");
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            if (Optional.ofNullable(ReflectionUtils.getField(fields[i], entity)).isPresent()) {
                if (!fields[i].getName().equals("id") && !fields[i].getName().equals("email")) {
                    sql.append(fields[i].getName()).append(i + 1 < fields.length ? "=?," : " ");
                    params.add(ReflectionUtils.getField(fields[i], entity));
                }
            }
        }
        return sql;
    }
}
