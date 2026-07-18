package com.mohit.lld.logger.appender;

import com.mohit.lld.logger.LogMessage;
import com.mohit.lld.logger.formatter.LogFormatter;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileAppender implements  Appender {
    LogFormatter formatter;
    BufferedWriter out;
    public FileAppender(LogFormatter formatter, String fileName) {
        this.formatter = formatter;
        try {
            out = new BufferedWriter(new FileWriter(fileName, true));
        } catch (Exception e) {

        }
    }
    @Override
    public void append(LogMessage message) {

    }
}
