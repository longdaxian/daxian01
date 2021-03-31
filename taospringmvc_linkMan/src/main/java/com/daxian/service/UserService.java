package com.daxian.service;

import com.daxian.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void add(User user);
}
