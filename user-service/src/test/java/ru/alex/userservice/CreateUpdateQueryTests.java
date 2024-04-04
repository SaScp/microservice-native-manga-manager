package ru.alex.userservice;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;
import ru.alex.userservice.model.User;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class CreateUpdateQueryTests {

    private static List<User> users;

    @BeforeAll
    public static void init() {
        users = new ArrayList<>();
        users.add(new User("<ID>", "<EMAIL>",
                "<PASSWORD>", "<USER>","USER",
                null, null, null));
    }


    @Test
    public void testCreateQueryWhenAllUpdateParam() {
        assertEquals(6, update(new User("1", "<EMAIL>",
                "<PASSWORD>", "user", "user",
                LocalDateTime.now(), LocalDateTime.now(), 'w')));
    }
    @Test
    public void testCreateQueryWhenFullNameAndDataOfBirthUpdateParam() {
        assertEquals(2, update(new User(null, "<EMAIL>",
                null, null, "user",
                LocalDateTime.now(), null, null)));
    }
    @Test
    public void testCreateQueryWhenAllUpdateParamIsNull() {
        assertEquals(0, update(new User(null, null,
                null, null, null,
                null, null, null)));
    }
    @Test
    public void testCreateWhenOnlyEmailUpdateParamIsNotNullInQuery() {
        assertEquals(0, update(new User(null, "<EMAIL>",
                null, null, null,
                null, null, null)));
    }

    @Test
    public void testCreateWhenOnlyEmailAndIdUpdateParamIsNotNullInQuery() {
        assertEquals(0, update(new User("<ID>", "<EMAIL>",
                null, null, null,
                null, null, null)));
    }
    @Test
    public void testCreateWhenOnlyIdUpdateParamIsNotNullInQuery() {
        assertEquals(0, update(new User("<ID>", null,
                null, null, null,
                null, null, null)));
    }

    @Test
    public void testCreateWhenThreeUpdateParamIsNotNullInQuery() {
        assertEquals(3, update(new User("<ID>", "<EMAIL>",
                "<PASSWORD>", "<USER>","USER",
                null, null, null)));
    }

    private int update(User entity) {
        if (entity.getEmail() == null && entity.getId() == null) {
            log.error("an id or email must be present");
            return 0;
        }

        int paramIndex = 0;
        Field[] fields = entity.getClass().getDeclaredFields();
        List<Object> params = new ArrayList<>();
        StringBuilder sql = generateUpdateDataForQuery(fields, params, entity);

        if ("UPDATE user_microservice.t_user SET ".length() == sql.toString().length()) {
            log.error("there are no updated elements in the request");
            return 0;
        }
        sql.append("WHERE id =? or email=?");

        for (var i : params)
            paramIndex++;

        return paramIndex;
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
