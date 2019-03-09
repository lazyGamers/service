package com.lazygamers.services.impl.logs;

import com.lazygamers.entities.logs.LogEntry;
import com.lazygamers.entities.logs.LogSeverity;
import com.lazygamers.services.LogService;
import com.lazygamers.services.configuration.GameServiceConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.logging.Logger;

@ApplicationScoped
public class LogServiceImpl implements LogService {
    
    private static final Logger LOG = Logger.getLogger(LogServiceImpl.class.getName());
    
    @Inject
    private GameServiceConfiguration configuration;
    
    @PersistenceContext(unitName = "main-jpa-unit")
    private EntityManager em;
    
    @Override
    @Transactional
    public void info(String message) {
        LOG.info(message);
        this.saveLog(LogSeverity.INFO, message);
    }
    
    @Override
    @Transactional
    public void debug(String message) {
        if (this.shouldExecute(new LogSeverity[]{LogSeverity.DEBUG})) {
            LOG.info("[DEBUG] " + message);
            this.saveLog(LogSeverity.DEBUG, message);
        }
    }
    
    @Override
    @Transactional
    public void warn(String message) {
        if (this.shouldExecute(new LogSeverity[]{LogSeverity.DEBUG, LogSeverity.WARNING})) {
            LOG.warning(message);
            this.saveLog(LogSeverity.WARNING, message);
        }
    }
    
    @Override
    @Transactional
    public void error(String message) {
        if (this.shouldExecute(new LogSeverity[]{LogSeverity.DEBUG, LogSeverity.WARNING, LogSeverity.ERROR})) {
            LOG.severe(message);
            this.saveLog(LogSeverity.ERROR, message);
        }
    }
    
    @Override
    @Transactional
    public void error(Throwable error) {
        if (this.shouldExecute(new LogSeverity[]{LogSeverity.DEBUG, LogSeverity.WARNING, LogSeverity.ERROR})) {
            error.printStackTrace();
            this.error(error.getMessage());
        }
    }
    
    private void saveLog(LogSeverity severity, String message) {
        LogEntry entry = new LogEntry();
        entry.setLogDate(new Date());
        entry.setSeverity(severity);
        entry.setMessage(message);
        em.persist(entry);
    }
    
    private boolean shouldExecute(LogSeverity[] allowedSeverities) {
        LogSeverity activeSeverity;
        try {
            activeSeverity = LogSeverity.valueOf(configuration.getLogging().getSeverity());
        } catch (IllegalArgumentException exc) {
            activeSeverity = LogSeverity.WARNING;
        }
        for (LogSeverity severity : allowedSeverities) {
            if (severity.equals(activeSeverity)) {
                return true;
            }
        }
        return false;
    }
}
