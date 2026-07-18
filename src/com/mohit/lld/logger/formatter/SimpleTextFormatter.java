package com.mohit.lld.logger.formatter;

import com.mohit.lld.logger.LogMessage;

public class SimpleTextFormatter implements LogFormatter {
    @Override
    public String format(LogMessage message) {
        return String.format("Log Level : %s \n Message : %s\n",message.getLevel(),message.getMessage());
    }
}
