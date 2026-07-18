package com.mohit.lld.logger.loghandler;

import com.mohit.lld.logger.LogLevel;


public class InfoHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        if(level == LogLevel.INFO){
            return true;
        }
        return false;
    }
}
