package com.nzhussup.javadatamanagementservice.service;

import com.nzhussup.javadatamanagementservice.entity.UserEntity;
import com.nzhussup.javadatamanagementservice.model.AuthRequest;
import com.nzhussup.javadatamanagementservice.model.AuthResponse;
import com.nzhussup.javadatamanagementservice.model.User;
import com.nzhussup.javadatamanagementservice.repository.AuthRepo;
import com.nzhussup.javadatamanagementservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthRepo authRepo;


    public Optional<UserEntity> authFindByEmail(String email) {
        return authRepo.authFindByEmail(email); // Directly return the Optional from the repository
    }

    public UserEntity registerUser(AuthRequest request) {
        UserEntity userEntity = new UserEntity(request.getEmail(),
                PasswordUtil.hashPassword(request.getPassword()));
        return authRepo.register(userEntity);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public List<UserEntity> findAllAdmin() {
        return authRepo.findAll();
    }

    public void add(User user) {
        userRepo.add(user);
    }

    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    public void deleteByEmailAdmin(String email) {
        authRepo.deleteByEmail(email);
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
