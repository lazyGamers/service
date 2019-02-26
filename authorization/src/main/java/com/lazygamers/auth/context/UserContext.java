package com.lazygamers.auth.context;

import java.util.List;

public class UserContext {
    
    private User user;
    
    public UserContext() {
        this.user = null;
    }
    
    public UserContext(String username, String userId, List<String> roles) {
        this.user = new User(username, userId, roles);
    }
    
    public boolean userIsPresent() {
        return this.user != null;
    }
    
    public String getUsername() {
        return user.username;
    }
    
    public String getUserId() {
        return user.userId;
    }
    
    public List<String> getUserRoles() {
        return user.roles;
    }
    
    public static class User {
        private String username;
        private String userId;
        private List<String> roles;
        
        User(String username, String userId, List<String> roles) {
            this.username = username;
            this.userId = userId;
            this.roles = roles;
        }
    }
}
