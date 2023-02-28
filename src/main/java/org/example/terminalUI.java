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
            data = scanner.nextLine();
            for(UserInputIF UserInputIF : services) {
                UserInputIF.userInput(data);
            }
        }
    }
}
