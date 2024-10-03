package com.nzhussup.javadatamanagementservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class User {

    private int userid;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String username;

    public User() {
        this(0, "default", "default", "default", "default", "default");
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
