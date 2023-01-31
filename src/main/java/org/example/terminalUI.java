package org.example;

import org.example.services.CheckAlarms;
import org.example.services.changeTime;

public class terminalUI {
    public static void main(String[] args) {

        UserInputIF[] services = {(UserInputIF) new CheckAlarms(), (UserInputIF) new changeTime()};
        while (true) {

        }
    }
}
