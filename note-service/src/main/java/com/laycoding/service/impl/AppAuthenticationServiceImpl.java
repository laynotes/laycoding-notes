package com.laycoding.service.impl;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AppAuthenticationServiceImpl extends AbstractAuthenticationToken {
    private final Object principal;
    private Object credentials;
    public AppAuthenticationServiceImpl(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true); // must use super, as we override
    }

    public AppAuthenticationServiceImpl(Object principal, Object credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
    }


    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

        super.setAuthenticated(isAuthenticated);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        credentials = null;
    }
}

