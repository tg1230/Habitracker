package com.Habitracker.service;

import com.Habitracker.modal.User;

import java.util.List;

public interface UserService {
    List<User> get();

    User get(int id);

    void save(User user);

    void delete(int id);
}