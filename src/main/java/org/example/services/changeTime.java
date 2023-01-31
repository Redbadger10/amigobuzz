package org.example.services;

import org.example.UpdateIF;
import org.example.UserInputIF;

import java.text.SimpleDateFormat;
import java.util.Date;

public class changeTime implements UpdateIF, UserInputIF {

    SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    Date readableTime;
    long offset = 0;
    @Override
    public void updateTime(long currentTimeMs) {
        readableTime = new Date(currentTimeMs + offset);
        System.out.println(sdf.format(readableTime));
    }
    public void userInput(String input){
        if(input == "minuteup"){
            offset += 60000;
        } else if (input == "minutedown") {
            offset -= 60000;
        } else if (input == "hourup") {
            offset += 3600000;
        } else if (input == "hourdown") {
            offset -=3600000;
        }
    }
}
