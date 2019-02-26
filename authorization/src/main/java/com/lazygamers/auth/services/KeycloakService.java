package com.lazygamers.auth.services;

import org.keycloak.representations.AccessToken;

import java.util.List;

public interface KeycloakService {

    public AccessToken getToken();
    
    public List<String> getRealmRoles();
    
    public List<String> getClientRoles(String clientName);
}
