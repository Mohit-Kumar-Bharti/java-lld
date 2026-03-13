package com.mohit.logger;

public class ErrorLogger extends Logger{
    public ErrorLogger(Logger nextLogger) {
        super( nextLogger);
    }

    @Override
    public void printLog(LogLevel logLevel, String message) {
        if (logLevel == LogLevel.ERROR) {
            System.out.println("Error : " + message);
        } else {
            nextLogger.printLog(logLevel,message);
        }
    }
}
