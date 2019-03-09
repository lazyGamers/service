package com.lazygamers.services.configuration;

public class LoggingConfiguration {

    private String severity = "WARNING";
    
    public String getSeverity() {
        return severity;
    }
    
    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
