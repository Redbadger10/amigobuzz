package org.example;

import org.example.services.CheckAlarms;
import org.example.services.changeTime;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Timer time = new Timer();

        UpdateIF[] services = {new CheckAlarms(), new changeTime()};

        time.schedule(new TimerTask() {
            @Override
            public void run() {
                long currentTimeMs = System.currentTimeMillis();
                //System.out.println(System.currentTimeMillis());
                for(UpdateIF updateIF : services) {
                    updateIF.updateTime(currentTimeMs);
                }
            }
        }, 0, 10000);
    }
}