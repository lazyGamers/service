package com.lazygamers.entities.logs;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logs")
@NamedQueries({
    @NamedQuery(name = LogEntry.FIND_BY_SEVERITY, query = "SELECT l FROM LogEntry l WHERE l.severity = :severity")
})
public class LogEntry {
    
    public static final String FIND_BY_SEVERITY = "findBySeverity";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "severity")
    @Enumerated(EnumType.STRING)
    private LogSeverity severity;
    
    @Column(name = "log_date")
    private Date logDate;
    
    @Column(name = "message")
    private String message;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public LogSeverity getSeverity() {
        return severity;
    }
    
    public void setSeverity(LogSeverity severity) {
        this.severity = severity;
    }
    
    public Date getLogDate() {
        return logDate;
    }
    
    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
