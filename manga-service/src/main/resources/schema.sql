CREATE SCHEMA IF NOT EXISTS manga_microservice;

CREATE TABLE IF NOT EXISTS manga_microservice.t_genre
(
    id    SERIAL primary key,
    genre VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS manga_microservice.t_type
(
    id     SERIAL primary key,
    c_type VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS manga_microservice.t_manga
(
    id             VARCHAR(255) primary key,
    main_name      VARCHAR(255)                   NOT NULL,
    secondary_name VARCHAR(255)                   NOT NULL,
    issue_year     INT                            NOT NULL,
    avg_rating     NUMERIC(10, 2)                 NOT NULL,
    c_type         INTEGER REFERENCES t_type (id) NOT null,
    is_yaoi        BOOLEAN                        NOT NULL,
    is_erotic      BOOLEAN                        NOT NULL,
    img            VARCHAR(255)                   NOT NULL,
    rus_name       VARCHAR(255)                   NOT NULL,
    en_name        VARCHAR(255)                   NOT NULL,
    count_chapters INTEGER                        NOT NULL
    );

CREATE TABLE IF NOT EXISTS t_manga_t_genre
(
    manga_id VARCHAR(255) REFERENCES manga_microservice.t_manga(id),
    genre_id INT REFERENCES manga_microservice.t_type(id),
    PRIMARY KEY (manga_id, genre_id)
    );

