package ru.alex.userservice.SQL;

public final class SQLConstant {
    public static final String DELETE_QUERY = "DELETE FROM user_microservice.t_user WHERE id=?";

    public static final String SELECT_QUERY = "SELECT * FROM user_microservice.t_user";

    public static final String BEGIN_UPDATE_QUERY = "UPDATE user_microservice.t_user SET ";

    public static final String END_UPDATE_QUERY = "WHERE id =? or email=?";

    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM user_microservice.t_user WHERE id=?";
}
