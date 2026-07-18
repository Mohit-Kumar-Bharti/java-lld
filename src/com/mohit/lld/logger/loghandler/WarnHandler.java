package com.mohit.lld.logger.loghandler;

import com.mohit.lld.logger.LogLevel;

public class WarnHandler extends LogHandler{
    @Override
    protected boolean canHandle(LogLevel level) {
        if(level == LogLevel.ERROR){
            return true;
        }
        return false;
    }
}
