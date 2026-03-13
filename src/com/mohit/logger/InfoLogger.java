package com.mohit.logger;

public class InfoLogger extends Logger{
    public InfoLogger(Logger nextLogger) {
        super( nextLogger);
    }

    @Override
    public void printLog(LogLevel logLevel, String message) {
        if (logLevel == LogLevel.INFO) {
            System.out.println("Info : " + message);
        } else {
            nextLogger.printLog(logLevel,message);
        }
    }
}
