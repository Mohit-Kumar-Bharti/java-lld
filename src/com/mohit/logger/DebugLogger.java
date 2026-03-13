package com.mohit.logger;

public class DebugLogger extends Logger{
    public DebugLogger(Logger nextLogger) {
        super( nextLogger);
    }

    @Override
    public void printLog(LogLevel logLevel, String message) {
        if (logLevel == LogLevel.DEBUG) {
            System.out.println("Debug : " + message);
        } else {
            nextLogger.printLog(logLevel,message);
        }
    }
}
