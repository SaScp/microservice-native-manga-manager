package ru.alex.userservice.SQL;

public final class UserRoleSQLConstant {

    public static final String SAVE_USER_ROLE_QUERY = "INSERT INTO user_microservice.t_user_t_role (user_id, role_id) VALUES (?,?)";

    public static final String DELETE_USER_ROLE_BY_USER_ID_QUERY = "DELETE FROM user_microservice.t_user_t_role WHERE user_id=? ";

    public static final String DELETE_USER_ROLE_BY_ROLE_ID_QUERY = "DELETE FROM user_microservice.t_user_t_role WHERE role_id=? ";

    public static final String SELECT_USER_ROLE_BY_USER_ID_QUERY = "SELECT * FROM ";
}
