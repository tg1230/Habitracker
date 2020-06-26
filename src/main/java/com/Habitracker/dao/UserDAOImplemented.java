package com.Habitracker.dao;

import com.Habitracker.modal.User;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class UserDAOImplemented implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> get() {
        Session currSession = entityManager.unwrap(Session.class);
        Query<User> query = currSession.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User get(int id) {
        Session currSession = entityManager.unwrap(Session.class);
        return currSession.get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session currSession = entityManager.unwrap(Session.class);
        currSession.saveOrUpdate(user);
    }

    @Override
    public void delete(int id) {
        Session currSession = entityManager.unwrap(Session.class);
        User user = currSession.get(User.class, id);
        currSession.delete(user);
    }
}
