package com.mohit.lld.logger.loghandler;

import com.mohit.lld.logger.LogLevel;

public class DebugHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        if(level == LogLevel.DEBUG) {
            return true;
        }
        return false;
    }
}
