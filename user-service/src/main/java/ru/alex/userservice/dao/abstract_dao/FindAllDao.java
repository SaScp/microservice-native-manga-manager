package ru.alex.userservice.dao.abstract_dao;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface FindAllDao<T> {

    Optional<List<T>> findAll();
}
