package com.mohit.lld.logger.appender;

import com.mohit.lld.logger.LogMessage;
import com.mohit.lld.logger.formatter.LogFormatter;

public class ConsoleAppender implements Appender {
    private LogFormatter formatter;
    public ConsoleAppender(LogFormatter formatter) {
        this.formatter = formatter;
    }
    @Override
    public void append(LogMessage message) {
        String msg  = formatter.format(message);
        System.out.println(msg);
    }
}
