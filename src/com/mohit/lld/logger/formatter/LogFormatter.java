package com.mohit.lld.logger.formatter;

import com.mohit.lld.logger.LogMessage;

public interface LogFormatter {
    String format(LogMessage message);
}
