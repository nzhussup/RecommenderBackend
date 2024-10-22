package com.nzhussup.javadatamanagementservice.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserPrincipalAuthToken extends AbstractAuthenticationToken {

    private final UserPrincipal principal;

    public UserPrincipalAuthToken(UserPrincipal userPrincipal) {
        super(userPrincipal.getAuthorities());
        this.principal = userPrincipal;
        setAuthenticated(true);
    }
    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserPrincipal getPrincipal() {
        return principal;
    }

}
