package org.example;

import org.example.services.CheckAlarms;
import org.example.services.changeTime;

import java.util.Scanner;


public class terminalUI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String data;

        UserInputIF[] services = {new CheckAlarms(), new changeTime()};
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
