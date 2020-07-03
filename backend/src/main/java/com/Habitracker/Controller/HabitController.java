package com.Habitracker.Controller;

import com.Habitracker.modal.Habit;
import com.Habitracker.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @GetMapping("/Habit")
    public List<Habit> get() {
        return habitService.get();
    }

    @PostMapping("/Habit")
    public Habit save(@RequestBody Habit habit) {
        habitService.save(habit);
        return habit;
    }

    @PostMapping("/HabitAdd")
    public Habit save(@RequestBody String name) {
        Habit newHabit = new Habit();
        newHabit.setName(name);
        newHabit.setStreak(0);
        newHabit.setHabitId(200);
        habitService.save(newHabit);
        return newHabit;
    }

    @GetMapping("/Habit/{id}")
    public Habit get(@PathVariable int id) {
        return habitService.get(id);
    }

    @DeleteMapping("/Habit/{id}")
    public String delete(@PathVariable int id) {

        habitService.delete(id);
        return "Habit removed with id "+id;

    }

    @PutMapping("/Habit")
    public Habit update(@RequestBody Habit habit) {
        habitService.save(habit);
        return habit;
    }
}
