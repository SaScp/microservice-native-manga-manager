CREATE SCHEMA IF NOT EXISTS auth_microservice;


CREATE TABLE IF NOT EXISTS auth_microservice.t_role
(
    id INT PRIMARY KEY,
    c_role VARCHAR(255) NOT NULL
    );
CREATE TABLE IF NOT EXISTS auth_microservice.t_auth_user(
    id                VARCHAR(255) primary key,
    email             VARCHAR(255) UNIQUE NOT NULL,
    password          VARCHAR(255)        NOT NULL,
    username          VARCHAR(255)        NOT NULL
);
CREATE TABLE IF NOT EXISTS auth_microservice.t_role_t_user
(
    role_id       VARCHAR(255) REFERENCES user_microservice.t_role (id),
    user_id VARCHAR(255) REFERENCES user_microservice.t_user (id),
    PRIMARY KEY (role_id, user_id)
    );