CREATE SCHEMA IF NOT EXISTS user_microservice;

CREATE TABLE IF NOT EXISTS user_microservice.t_role
(
    id     SERIAL primary key,
    c_role VARCHAR(255) NOT NULL
    );
CREATE TABLE IF NOT EXISTS user_microservice.t_user
(
    id                VARCHAR(255) primary key,
    email             VARCHAR(255) UNIQUE NOT NULL,
    password          VARCHAR(255)        NOT NULL,
    username          VARCHAR(255)        NOT NULL,
    full_name         VARCHAR(255)        NOT NULL,
    date_of_birth     DATE                NOT NULL,
    registration_date DATE                NOT NULL,
    sex               CHAR                NOT NULL
    );

CREATE TABLE IF NOT EXISTS user_microservice.t_user_t_role
(
    user_id VARCHAR(255) REFERENCES user_microservice.t_user (id),
    role_id INT REFERENCES user_microservice.t_role (id),
    PRIMARY KEY (user_id, role_id)
    );