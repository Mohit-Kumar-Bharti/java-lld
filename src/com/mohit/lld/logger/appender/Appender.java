package com.mohit.lld.logger.appender;

import com.mohit.lld.logger.LogMessage;

public interface Appender {
    void append(LogMessage message);
}
