package org.example.services;

import org.example.GUI;
import org.example.UpdateIF;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MasterClock {
    private static final MasterClock INSTANCE = new MasterClock();
    public static MasterClock getInstance(){
        return INSTANCE;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    public static Date readableTime;
    long offset = 0;

    public void start(){
        Timer time = new Timer();

        UpdateIF[] services_ibe = {new CheckAlarms(), new GUI()};

        time.schedule(new TimerTask() {
            @Override
            public void run() {
                long currentTimeMs = System.currentTimeMillis();
                //System.out.println(System.currentTimeMillis());
                for(UpdateIF updateIF : services_ibe) {
                    updateIF.updateTime(currentTimeMs + offset);
                }
            }
        }, 0, 1000);
    }


    /*
    @Override
    public void updateTime(long currentTimeMs) {
        readableTime = new Date((currentTimeMs + offset));
    }
    */

    public void incMinute(){
        offset += 60000;
    }
    public void decMinute(){
        offset -= 60000;
    }
    public void incHour(){
        offset += 3600000;
    }
    public void decHour(){
        offset -=3600000;
    }

}
