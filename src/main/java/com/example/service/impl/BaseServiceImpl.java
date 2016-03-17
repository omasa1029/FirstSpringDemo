package com.example.service.impl;

import com.example.entity.User;
import com.example.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public T add(T entity) {
        return null;
    }

    @Override
    public T modify(T entity) {
        return null;
    }

    @Override
    public void remove(Long id) {
    }

}
