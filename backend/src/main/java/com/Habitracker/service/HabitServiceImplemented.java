package com.Habitracker.service;

import com.Habitracker.dao.HabitDAO;
import com.Habitracker.dao.UserDAO;
import com.Habitracker.modal.Habit;
import com.Habitracker.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HabitServiceImplemented implements HabitService {

    @Autowired
    private HabitDAO habitDao;

    @Override
    public List<Habit> get() {
        return habitDao.get();
    }

    @Override
    public Habit get(int id) {
        return habitDao.get(id);
    }

    @Override
    public void save(Habit habit) {
        habitDao.save(habit);
    }


    @Override
    public void delete(int id) {
        habitDao.delete(id);
    }
}
