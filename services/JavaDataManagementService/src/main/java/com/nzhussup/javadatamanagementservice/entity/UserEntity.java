package com.nzhussup.javadatamanagementservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private Long id;
    private String email;

    private String password;
    private String role;


    public UserEntity(String email, String password) {
        this((long) 1, email, password, "ROLE_USER");
    }
    public UserEntity(String email, String password, String role) {
        this((long) 1, email, password, role);
    }


}
