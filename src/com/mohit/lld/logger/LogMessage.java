package com.mohit.lld.logger;

public class LogMessage {
    LogLevel level;
    String message;

    public LogMessage(LogLevel level, String message) {
        this.level = level;
        this.message = message;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
