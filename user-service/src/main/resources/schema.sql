CREATE SCHEMA IF NOT EXISTS user_microservice;

CREATE TABLE IF NOT EXISTS user_microservice.t_user
(
    id                VARCHAR(255) primary key,
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
