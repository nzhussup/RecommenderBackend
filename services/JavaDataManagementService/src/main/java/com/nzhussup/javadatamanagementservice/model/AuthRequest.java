package com.nzhussup.javadatamanagementservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthRequest {
    @Email
    @NotBlank
    private String email;

    private String password;

}
