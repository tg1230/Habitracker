package com.Habitracker.service;

import com.Habitracker.modal.Habit;
import com.Habitracker.modal.User;

import java.util.List;

public interface HabitService {
    List<Habit> get();

    Habit get(int id);

    void save(Habit habit);

    void delete(int id);
}