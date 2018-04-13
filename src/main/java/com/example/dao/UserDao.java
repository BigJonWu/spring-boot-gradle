package com.example.dao;

import com.example.domain.User;

import java.awt.print.Pageable;
import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUser(Integer id);

    void update(User user);

    void insert(User user);

    void insertAll(List<User> users);

    void remove(Integer id);

    List<User> findByPage(User user, Pageable pageable);

}