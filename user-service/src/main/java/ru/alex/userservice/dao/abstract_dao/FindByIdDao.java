package ru.alex.userservice.dao.abstract_dao;

import java.util.Optional;

public interface FindByIdDao<T, ID> {
    Optional<T> findById(ID id);

}
