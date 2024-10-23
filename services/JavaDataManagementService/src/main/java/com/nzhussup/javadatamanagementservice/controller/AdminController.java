package com.nzhussup.javadatamanagementservice.controller;

import com.nzhussup.javadatamanagementservice.entity.UserEntity;
import com.nzhussup.javadatamanagementservice.model.Item;
import com.nzhussup.javadatamanagementservice.model.Response;
import com.nzhussup.javadatamanagementservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    private Response response;

    private Response errorResponse(Exception e) {
        e.printStackTrace();
        response.setMessage(e.getMessage());
        response.setObj(null);
        return response;
    }

    @GetMapping("")
    public String index() {
        return "Admin root";
    }

    @GetMapping("/all")
    public Response<List<UserEntity>> getAll() {
        try {
            response.setMessage("Successfully retrieved all users");
            response.setObj(userService.findAllAdmin());
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @GetMapping("/{email}")
    public Response<Item> getUserByEmail(@PathVariable String email) {
        try {
            response.setObj(userService.authFindByEmail(email));
            response.setMessage("User found successfully");
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @DeleteMapping("/delete/{email}")
    public Response<UserEntity> deleteUserByEmail(@PathVariable String email) {
        try {
            userService.deleteByEmailAdmin(email);
            response.setObj(null);
            response.setMessage("User deleted successfully");
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

}
