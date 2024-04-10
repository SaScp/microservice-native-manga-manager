CREATE SCHEMA IF NOT EXISTS user_microservice;

CREATE TABLE IF NOT EXISTS user_microservice.t_role
(
    id INT PRIMARY KEY,
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
    registration_date DATE                NOT NULL
    );
CREATE TABLE IF NOT EXISTS user_microservice.t_collection
(
    id          VARCHAR(255) primary key,
    c_name      VARCHAR(255) NOT NULL,
    manga_count INT          NOT NULL,
    description TEXT,
    user_id VARCHAR(255) REFERENCES user_microservice.t_user(id) ON DELETE CASCADE
    );
CREATE TABLE IF NOT EXISTS user_microservice.t_role_t_user
(
    role_id       VARCHAR(255) REFERENCES user_microservice.t_role (id),
    user_id VARCHAR(255) REFERENCES user_microservice.t_user (id),
    PRIMARY KEY (role_id, user_id)
    );
