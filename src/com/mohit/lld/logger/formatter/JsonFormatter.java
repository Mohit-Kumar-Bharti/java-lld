package com.mohit.lld.logger.formatter;

import com.mohit.lld.logger.LogMessage;

public class JsonFormatter implements LogFormatter {
    @Override
    public String format(LogMessage message) {
        return String.format("{ \"level\" : \"%s\" , \"message\" : \"%s\"}",message.getLevel(),message.getMessage());
    }
}
