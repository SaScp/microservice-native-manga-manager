package ru.alex.userservice.dao.abstract_dao;

import java.util.Optional;

public interface CrudDao<T> {

    Optional<T> save(T entity);

    int update(T entity);

    int delete(Long id);

    Optional<T> findById(Long id);
}
