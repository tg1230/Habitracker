package com.Habitracker.Controller;

import java.util.List;

import com.Habitracker.modal.User;
import com.Habitracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/User")
    public List<User> get() {
        return userService.get();
    }

    @PostMapping("/User")
    public User save(@RequestBody User User) {
        userService.save(User);
        return User;
    }

    @GetMapping("/User/{id}")
    public User get(@PathVariable int id) {
        return userService.get(id);
    }

    @DeleteMapping("/User/{id}")
    public String delete(@PathVariable int id) {

        userService.delete(id);
        return "User removed with id "+id;

    }

    @PutMapping("/User")
    public User update(@RequestBody User User) {
        userService.save(User);
        return User;
    }
}
