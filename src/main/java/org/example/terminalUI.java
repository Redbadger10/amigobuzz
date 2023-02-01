package org.example;

import org.example.services.CheckAlarms;
import org.example.services.MasterClock;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class terminalUI {
    public static void main(String[] args) {

        MasterClock.getInstance().start();

        Scanner scanner = new Scanner(System.in);
        String data;

        UserInputIF[] services = {new CheckAlarms()};
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
