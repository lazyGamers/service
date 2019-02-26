package com.lazygamers.auth.producers;

import com.lazygamers.auth.context.UserContext;
import com.lazygamers.auth.services.KeycloakService;
import org.keycloak.representations.AccessToken;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.ArrayList;

@RequestScoped
public class UserContextProducer {
    
    @Inject
    private KeycloakService keycloakService;
    
    @Produces
    @RequestScoped
    public UserContext produceUserContext() {
        AccessToken token = keycloakService.getToken();
        if (token == null) {
            return new UserContext();
        }
        return new UserContext(token.getPreferredUsername(), token.getSubject(), new ArrayList<>());
    }
    
}
