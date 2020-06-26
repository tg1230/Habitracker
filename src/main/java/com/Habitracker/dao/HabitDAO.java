package com.Habitracker.dao;

import com.Habitracker.modal.Habit;
import com.Habitracker.modal.User;

import java.util.List;

public interface HabitDAO {

    List<Habit> get();

    Habit get(int id);

    void save(Habit habit);

    void delete(int id);
}
