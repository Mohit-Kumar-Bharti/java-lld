package com.mohit.lld.logger;

import com.mohit.lld.logger.appender.ConsoleAppender;
import com.mohit.lld.logger.formatter.JsonFormatter;
import com.mohit.lld.logger.formatter.SimpleTextFormatter;

public class LoggerDemo {
    public static void main(String[] args) {
        LoggerServ loggerServ = LoggerServ.getInstance();
        loggerServ.addAppender(LogLevel.DEBUG, new ConsoleAppender(new JsonFormatter()));

        loggerServ.debug("hello from demo debug");

        loggerServ.addAppender(LogLevel.INFO, new ConsoleAppender(new SimpleTextFormatter()));
        loggerServ.info("hello from demo info");
    }
}
