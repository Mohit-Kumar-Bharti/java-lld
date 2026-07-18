package com.mohit.lld.logger.loghandler;

import com.mohit.lld.logger.LogLevel;
import com.mohit.lld.logger.LogMessage;
import com.mohit.lld.logger.appender.Appender;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LogHandler {
    LogHandler next;
    List<Appender> appenders = new CopyOnWriteArrayList<Appender>();

    public void addAppender(Appender appender) {
        appenders.add(appender);
    }

    public void setNext(LogHandler next) {
        this.next = next;
    }

    public void notifyAppenders(LogMessage message) {
        for (Appender appender : appenders) {
            appender.append(message);
        }
    }

    public void handleLog(LogMessage message) {
        if(canHandle(message.getLevel())) {
            notifyAppenders(message);
        } else  if(next != null) {
            next.handleLog(message);
        }

    }

    protected abstract boolean canHandle(LogLevel level);
}
