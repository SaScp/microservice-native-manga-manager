package ru.alex.userservice.SQL;

public final class UserSQLConstant {
    public static final String DELETE_USER_QUERY = "DELETE FROM user_microservice.t_user WHERE id=?";

    public static final String SELECT_USER_QUERY = "SELECT * FROM user_microservice.t_user";

    public static final String BEGIN_UPDATE_USER_QUERY = "UPDATE user_microservice.t_user SET ";

    public static final String END_UPDATE_USER_QUERY = "WHERE id =? or email=?";

    public static final String SELECT_BY_ID_USER_QUERY = "SELECT * FROM user_microservice.t_user WHERE id=? LIMIT 1";

    public static final String SAVE_USER_QUERY = "INSERT INTO user_microservice.t_user" +
    "(id, email, password, username, full_name, date_of_birth, registration_date, c_role) VALUES (?,?,?,?,?,?,?,?)";

    public static final String SELECT_BY_EMAIL_QUERY = "SELECT * FROM user_microservice.t_user WHERE email=? LIMIT 1";


}
