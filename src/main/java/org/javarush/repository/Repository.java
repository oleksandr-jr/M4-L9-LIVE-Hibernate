package org.javarush.repository;

import org.javarush.entity.Entity;

import java.util.List;

public interface Repository<T extends Entity> {
    T findById(long id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
