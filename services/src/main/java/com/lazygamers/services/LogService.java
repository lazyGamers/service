package com.lazygamers.services;

/**
 * Service for logging messages
 */
public interface LogService {
    
    /**
     * Logs message as information
     * @param message message to be logged
     */
    void info(String message);
    
    /**
     * Logs debugging message
     * @param message message to be logged
     */
    void debug(String message);
    
    /**
     * Logs message as warning
     * @param message message to be logged
     */
    void warn(String message);
    
    /**
     * Logs message as error
     * @param message message to be logged
     */
    void error(String message);
    
    /**
     * Logs exception
     * @param error exception to be logged
     */
    void error(Throwable error);
}
