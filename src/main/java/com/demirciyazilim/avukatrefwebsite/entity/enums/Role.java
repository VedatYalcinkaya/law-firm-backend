package com.demirciyazilim.avukatrefwebsite.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    USER,
    ADMIN,
    MODERATOR,
    CUSTOMER,
    CORPORATE_CUSTOMER;

    @Override
    public String getAuthority() {
        return name();
    }
}
