package com.practise.angularspringboot.service;

import com.practise.angularspringboot.entity.User;
import com.practise.angularspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // function to create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }
    // function return a user by id or null in case it doesn't exist
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
    // function that retrieve all users from database
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    // function that update an existing user in database
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    // function that remove a user from database by it's id
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}