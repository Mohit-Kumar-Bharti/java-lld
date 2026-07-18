package com.mohit.lld.logger;

import com.mohit.lld.logger.appender.Appender;
import com.mohit.lld.logger.loghandler.*;
import com.mohit.lld.pubsub.message.Message;

public class LoggerServ {
    private static LoggerServ instance;
    LogHandler rootHandler;
    LogHandler debugHandler = new DebugHandler();
    LogHandler errorHandler = new ErrorHandler();
    LogHandler infoHandler = new InfoHandler();
    LogHandler warnHandler = new WarnHandler();

    private LoggerServ() {
        debugHandler.setNext(errorHandler);
        errorHandler.setNext(infoHandler);
        infoHandler.setNext(warnHandler);
        warnHandler.setNext(null);
        rootHandler = debugHandler;
    }

    public static LoggerServ getInstance() {
        if (instance == null) {
            instance = new LoggerServ();
        }
        return instance;
    }


    public void debug(String message) {
        LogMessage msg = new LogMessage(LogLevel.DEBUG, message);
        rootHandler.handleLog(msg);
    }

    public void error(String message) {
        LogMessage msg = new LogMessage(LogLevel.ERROR, message);
        rootHandler.handleLog(msg);
    }

    public void info(String message) {
        LogMessage msg = new LogMessage(LogLevel.INFO, message);
        rootHandler.handleLog(msg);
    }

    public void warn(String message) {
        LogMessage msg = new LogMessage(LogLevel.WARNING, message);
        rootHandler.handleLog(msg);
    }

    public void addAppender(LogLevel level, Appender appender) {
        switch (level) {
            case DEBUG: debugHandler.addAppender(appender); break;
            case ERROR: errorHandler.addAppender(appender); break;
            case INFO: infoHandler.addAppender(appender); break;
            case WARNING: warnHandler.addAppender(appender); break;
        }
    }
}
