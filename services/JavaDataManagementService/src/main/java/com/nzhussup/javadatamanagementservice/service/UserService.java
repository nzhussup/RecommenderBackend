package com.nzhussup.javadatamanagementservice.service;

import com.nzhussup.javadatamanagementservice.model.User;
import com.nzhussup.javadatamanagementservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void add(User user) {
        userRepo.add(user);
    }

    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    public void update(User user) {
        userRepo.update(user);
    }

    public User findById(int id) {
        return userRepo.findById(id);
    }

    public User findLastEntry() {
        return userRepo.findLastEntry();
    }
}
