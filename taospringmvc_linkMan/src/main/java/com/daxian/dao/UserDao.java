package com.daxian.dao;

import com.daxian.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void add(User user);
}
