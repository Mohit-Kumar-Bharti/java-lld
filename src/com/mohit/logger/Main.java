package com.mohit.logger;

public class Main {
    static void main() {
        System.out.println("here we go for logger..");

        Logger logger  = new DebugLogger(new ErrorLogger(new InfoLogger(null)));
        logger.printLog(LogLevel.INFO,"here is the info msg");


    }
}
