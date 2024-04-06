package ru.alex.userservice.dao.abstract_dao;

import java.util.Optional;

public interface DefaultDao<T, ID> {

    Optional<T> save(T entity);

    int update(T entity);

    int delete(ID id);

}
