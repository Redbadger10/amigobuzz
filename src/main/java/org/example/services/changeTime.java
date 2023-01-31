package org.example.services;

import org.example.UpdateIF;

import java.text.SimpleDateFormat;
import java.util.Date;

public class changeTime implements UpdateIF{

    SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    Date readableTime;
    @Override
    public void updateTime(long currentTimeMs) {
        readableTime = new Date(currentTimeMs);
        System.out.println(sdf.format(readableTime));
    }
    public void userInput(String input){

    }
}
