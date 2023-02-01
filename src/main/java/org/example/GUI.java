package org.example;

import org.example.services.MasterClock;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUI implements UpdateIF {
    private static final MasterClock masterClock = MasterClock.getInstance();
    JFrame frame = new JFrame("Current Time");
    JLabel time = new JLabel("CurrentTime");

    public GUI() {
        //frame.getContentPane().add(time);
        frame.setPreferredSize(new Dimension(800, 400));
        JPanel masterPanel = new JPanel(new GridLayout(3,1));
        JPanel topTimeButtons = new JPanel(new GridLayout(1,2));
        JPanel bottomTimeButtons = new JPanel(new GridLayout(1,2));

        JButton hourUp = new JButton("Hour Up");
        JButton hourDown = new JButton("Hour Down");
        JButton minuteUp = new JButton("Minute Up");
        JButton minuteDown = new JButton("Minute Down");

        masterPanel.add(topTimeButtons);
        masterPanel.add(time);
        masterPanel.add(bottomTimeButtons);

        topTimeButtons.add(hourUp);
        topTimeButtons.add(minuteUp);

        bottomTimeButtons.add(hourDown);
        bottomTimeButtons.add(minuteDown);

        frame.add(masterPanel);

        frame.pack();
        frame.setVisible(true);
    }
    SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    public static Date timeAsDate;
    String readableTime;
    @Override
    public void updateTime(long currentTimeMs) {
        timeAsDate = new Date(currentTimeMs);
        readableTime = sdf.format(timeAsDate);
        time.setText(readableTime);
        frame.repaint();
        frame.pack();
    }
}
