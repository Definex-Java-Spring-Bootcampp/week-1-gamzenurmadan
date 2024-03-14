package com.patika.kredinbizdenservice.loggers;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements ILogger{
    private static final ConsoleLogger instance = new ConsoleLogger();
    
    private ConsoleLogger(){

    }
    public static ConsoleLogger getInstance(){
        return instance;
    }

    public void log(String message){
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedTimestamp = timestamp.format(formatter);
        System.out.println("[" + formattedTimestamp + "] " + message);
    }
}
