package com.nzhussup.javadatamanagementservice.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponse {

    private String accessToken;
}
