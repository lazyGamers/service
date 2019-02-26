package com.lazygamers.auth.services.impl;

import com.lazygamers.auth.services.KeycloakService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RequestScoped
public class KeycloakServiceImpl implements KeycloakService {
    
    @Inject
    private HttpServletRequest request;
    
    @Override
    public AccessToken getToken() {
        Principal principal = request.getUserPrincipal();
        KeycloakPrincipal<?> keycloakPrincipal = (KeycloakPrincipal) principal;
        if (keycloakPrincipal == null) {
            return null;
        }
        KeycloakSecurityContext securityContext = keycloakPrincipal.getKeycloakSecurityContext();
        return securityContext.getToken();
    }
    
    @Override
    public List<String> getRealmRoles() {
        return null;
    }
    
    @Override
    public List<String> getClientRoles(String clientName) {
        return null;
    }
}
