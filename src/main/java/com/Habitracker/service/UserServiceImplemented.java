package com.Habitracker.service;

import com.Habitracker.dao.UserDAO;
import com.Habitracker.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImplemented implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    public List<User> get() {
        return userDao.get();
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }


    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
