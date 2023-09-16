package com.ruturaj.springbootbackend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User could not found with this id :" + id);
    }
}
