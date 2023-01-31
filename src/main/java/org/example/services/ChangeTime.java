package org.example.services;

import org.example.UpdateIF;
import org.example.UserInputIF;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeTime implements UpdateIF, UserInputIF {

    SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    public static Date readableTime;
    long offset = 0;

    public static final ChangeTime INSTANCE = new ChangeTime();

    private ChangeTime(){}
    @Override
    public void updateTime(long currentTimeMs) {
        readableTime = new Date((currentTimeMs + offset));
    }
    public void userInput(String input){
        if(input.equals("minuteup")){
            offset += 60000;
        } else if (input.equals("minutedown")) {
            offset -= 60000;
        } else if (input.equals("hourup")) {
            offset += 3600000;
        } else if (input.equals("hourdown")) {
            offset -=3600000;
        }
        System.out.println(offset);
    }
}
