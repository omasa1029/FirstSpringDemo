package com.example.service;

import com.example.entity.User;

public interface BaseService<T> {
    User get(Long id);

    T add(T entity);

    T modify(T entity);

    void remove(Long id);
}
