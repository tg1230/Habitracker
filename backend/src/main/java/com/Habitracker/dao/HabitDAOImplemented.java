package com.Habitracker.dao;

import com.Habitracker.modal.Habit;
import com.Habitracker.modal.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class HabitDAOImplemented implements HabitDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Habit> get() {
        Session currSession = entityManager.unwrap(Session.class);
        Query<Habit> query = currSession.createQuery("from Habit", Habit.class);
        return query.getResultList();
    }

    @Override
    public Habit get(int id) {
        Session currSession = entityManager.unwrap(Session.class);
        return currSession.get(Habit.class, id);
    }

    @Override
    public void save(Habit habit) {
        System.out.println(habit.toString());
        Session currSession = entityManager.unwrap(Session.class);
        currSession.saveOrUpdate(habit);
    }

    @Override
    public void delete(int id) {
        Session currSession = entityManager.unwrap(Session.class);
        Habit habit = currSession.get(Habit.class, id);
        currSession.delete(habit);
    }
}
