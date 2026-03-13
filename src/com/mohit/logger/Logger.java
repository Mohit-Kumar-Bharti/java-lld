package com.mohit.logger;

public class Logger {
    Logger nextLogger;
    public Logger( Logger nextLogger) {
        System.out.println("called");
        this.nextLogger = nextLogger;
    }

    public void printLog(LogLevel logLevel, String message) {
        return;
    }
}
