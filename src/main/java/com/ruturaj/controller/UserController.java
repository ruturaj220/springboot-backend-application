package com.ruturaj.controller;


import java.util.List;

import com.ruturaj.model.User;
import com.ruturaj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"http://localhost:3000"})
public class UserController {
    @Autowired
    UserService service;

    @PostMapping({"/addUser"})
    public String addUser(@RequestBody User user) {
        this.service.addUser(user);
        return "sucessfully user added";
    }

    @GetMapping({"/getUser"})
    public List<User> getAllUser() {
        return this.service.getAllUser();
    }

    @GetMapping({"/user/{id}"})
    public User getUser(@PathVariable Long id) {
        return this.service.getUser(id);
    }

    @PutMapping({"/user/{id}"})
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return this.service.updateUser(user, id);
    }

    @DeleteMapping({"/user/{id}"})
    public String deleteUser(@PathVariable Long id) {
        return this.service.deleteUser(id);
    }
}
