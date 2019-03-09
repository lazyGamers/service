package com.lazygamers.entities.logs;

public enum LogSeverity {
    INFO("INFO"),
    WARNING("WARNING"),
    ERROR("ERROR"),
    DEBUG("DEBUG");
    
    private String severity;
    
    LogSeverity(String severity) {
        this.severity = severity;
    }
    
    public String getSeverity() {
        return severity;
    }
}
