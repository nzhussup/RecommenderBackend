package com.nzhussup.javadatamanagementservice.controller;

import com.nzhussup.javadatamanagementservice.model.Response;
import com.nzhussup.javadatamanagementservice.model.User;
import com.nzhussup.javadatamanagementservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/users")
public class UserController {



    @Autowired
    private UserService userService;
    @Autowired
    private Response response;
    @Autowired
    private User user;

    private Response errorResponse(Exception e) {
        e.printStackTrace();
        response.setMessage(e.getMessage());
        response.setObj(null);
        return response;
    }

    @GetMapping("")
    public String root() {
        return "User root";
    }

    @GetMapping("/users/all")
    public Response<List<User>> getAllUsers() {
        try {
            response.setMessage("Successfully retrieved all users");
            response.setObj(userService.findAll());
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @PostMapping("/add")
    public Response<User> addUser(User user) {

        try {
            userService.add(user);
            response.setObj(userService.findLastEntry());
            response.setMessage("User added successfully");
            return response;

        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response<User> deleteItemById(@PathVariable int id) {
        try {
            userService.deleteById(id);
            response.setObj(null);
            response.setMessage("User deleted successfully");
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @PutMapping("/update")
    public Response<User> updateItem(User user) {
        try {
            userService.update(user);
            response.setObj(userService.findById(user.getUserid()));
            response.setMessage("Item updated successfully");
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @GetMapping("/{id}")
    public Response<User> getItemById(@PathVariable int id) {
        try {
            response.setObj(userService.findById(id));
            response.setMessage("User found successfully");
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @GetMapping("/last")
    public Response<User> getLastItem() {
        try {
            response.setObj(userService.findLastEntry());
            response.setMessage("Item found successfully");
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

}
