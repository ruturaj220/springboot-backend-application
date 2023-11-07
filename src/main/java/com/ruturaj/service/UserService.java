package com.ruturaj.service;


import com.ruturaj.exception.UserNotFoundException;
import com.ruturaj.model.User;
import com.ruturaj.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User getUser(Long id) {
        return (User)this.userRepo.findById(id).orElseThrow(() -> {
            return new UserNotFoundException(id);
        });
    }

    public User updateUser(User newUser, Long id) {
        return (User)this.userRepo.findById(id).map((user) -> {
            user.setName(newUser.getName());
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            return (User)this.userRepo.save(user);
        }).orElseThrow(() -> {
            return new UserNotFoundException(id);
        });
    }

    public String deleteUser(Long id) {
        if (!this.userRepo.existsById(id)) {
            throw new UserNotFoundException(id);
        } else {
            this.userRepo.deleteById(id);
            return "user with id " + id + " has been deleted successfully";
        }
    }
}