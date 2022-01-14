package com.interview.Authorization_and_survey.entity;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ADMIN,
    USER;


    @Override
    public String getAuthority() {
        return name();
    }
}
