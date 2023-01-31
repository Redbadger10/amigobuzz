package org.example;

import org.example.services.ChangeTime;

import javax.swing.*;

public class GUI implements UpdateIF {

    JFrame frame = new JFrame("Current Time");
    JLabel time = new JLabel("CurrentTime");
    public GUI() {
        frame.getContentPane().add(time);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void updateTime(long currentTimeMs) {
        time.setText(ChangeTime.readableTime.toString());
    }
}
