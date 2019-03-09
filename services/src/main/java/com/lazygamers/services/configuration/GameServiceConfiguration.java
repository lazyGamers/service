package com.lazygamers.services.configuration;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigBundle("game-service")
public class GameServiceConfiguration {
    
    private LoggingConfiguration logging = new LoggingConfiguration();
    
    public LoggingConfiguration getLogging() {
        return logging;
    }
    
    public void setLogging(LoggingConfiguration logging) {
        this.logging = logging;
    }
}
