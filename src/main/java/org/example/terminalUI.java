package org.example;

import org.example.services.CheckAlarms;
import org.example.services.ChangeTime;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class terminalUI {
    public static void main(String[] args) {

        Timer time = new Timer();

        UpdateIF[] services_ibe = {new CheckAlarms(), ChangeTime.INSTANCE, new GUI()};

        time.schedule(new TimerTask() {
            @Override
            public void run() {
                long currentTimeMs = System.currentTimeMillis();
                //System.out.println(System.currentTimeMillis());
                for(UpdateIF updateIF : services_ibe) {
                    updateIF.updateTime(currentTimeMs);
                }
            }
        }, 0, 1000);

        Scanner scanner = new Scanner(System.in);
        String data;

        UserInputIF[] services = {new CheckAlarms(), ChangeTime.INSTANCE};
        while (true) {
            System.out.println("To adjust the time, use the commands \"minuteup\" / \"minutedown\" to adjust the minutes, and used \"hourup\" / \"hourdown\" to adjust the hours.");
            System.out.println("To set an alarm, use the command \"alarm time\" (time is in military time) (ex: \"alarm 08:30\" or \"alarm 20:30\")");
            System.out.println();

            data = scanner.nextLine();
            for(UserInputIF UserInputIF : services) {
                UserInputIF.userInput(data);
            }
        }
    }
}
