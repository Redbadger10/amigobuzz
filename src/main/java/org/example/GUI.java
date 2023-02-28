package org.example;

import org.example.services.MasterClock;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUI implements UpdateIF {

    private static final GUI INSTANCE = new GUI();
    public static GUI getInstance(){
        return INSTANCE;
    }

    JFrame frame = new JFrame("Current Time");
    JLabel time = new JLabel("CurrentTime");
    JLabel alarmTime = new JLabel("AlarmTime");

    long alarmTimeMs = System.currentTimeMillis();


    SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");
    public static Date timeAsDate;
    public static Date alarmAsDate;
    String readableTime;
    String readableAlarm;

    private GUI() {



        //frame.getContentPane().add(time);
        frame.setPreferredSize(new Dimension(800, 400));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JPanel clockPanel = new JPanel(new GridLayout(3,1));
        JPanel topTimeButtons = new JPanel(new GridLayout(1,2));
        JPanel bottomTimeButtons = new JPanel(new GridLayout(1,2));
        JPanel timeContainer = new JPanel();

        JButton hourUp = new JButton("Hour Up");
        JButton hourDown = new JButton("Hour Down");
        JButton minuteUp = new JButton("Minute Up");
        JButton minuteDown = new JButton("Minute Down");

        JPanel alarmPanel = new JPanel(new GridLayout(4,1));
        JPanel topAlarmButtons = new JPanel(new GridLayout(1,2));
        JPanel bottomAlarmButtons = new JPanel(new GridLayout(1,2));
        JPanel alarmContainer = new JPanel();

        JButton alarmHourUp = new JButton("Hour Up");
        JButton alarmHourDown = new JButton("Hour Down");
        JButton alarmMinuteUp = new JButton("Minute Up");
        JButton alarmMinuteDown = new JButton("Minute Down");
        JButton alarmSet = new JButton("Set Alarm");






        hourUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MasterClock.getInstance().incHour();
            }
        });

        hourDown.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MasterClock.getInstance().decHour();
            }
        });

        minuteUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MasterClock.getInstance().incMinute();
            }
        });

        minuteDown.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MasterClock.getInstance().decMinute();
            }
        });

        alarmSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MasterClock.getInstance().setAlarm(alarmTimeMs);
            }
        });

        alarmHourUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                alarmTimeMs += 3600000;
                alarmAsDate = new Date(alarmTimeMs);
                readableAlarm = sdf.format(alarmAsDate);
                alarmTime.setText(readableAlarm);
                frame.repaint();
                frame.pack();
                System.out.println(alarmTimeMs);
            }
        });

        alarmHourDown.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                alarmTimeMs -= 3600000;
                alarmAsDate = new Date(alarmTimeMs);
                readableAlarm = sdf.format(alarmAsDate);
                alarmTime.setText(readableAlarm);
                frame.repaint();
                frame.pack();
            }
        });

        alarmMinuteUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                alarmTimeMs += 60000;
                alarmAsDate = new Date(alarmTimeMs);
                readableAlarm = sdf.format(alarmAsDate);
                alarmTime.setText(readableAlarm);
                frame.repaint();
                frame.pack();
            }
        });

        alarmMinuteDown.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                alarmTimeMs -= 60000;
                alarmAsDate = new Date(alarmTimeMs);
                readableAlarm = sdf.format(alarmAsDate);
                alarmTime.setText(readableAlarm);
                frame.repaint();
                frame.pack();
            }
        });

        alarmSet.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });


        clockPanel.add(topTimeButtons);
        clockPanel.add(timeContainer);
        clockPanel.add(bottomTimeButtons);

        topTimeButtons.add(hourUp);
        topTimeButtons.add(minuteUp);

        bottomTimeButtons.add(hourDown);
        bottomTimeButtons.add(minuteDown);

        timeContainer.add(time);



        alarmPanel.add(topAlarmButtons);
        alarmPanel.add(alarmContainer);
        alarmPanel.add(bottomAlarmButtons);
        alarmPanel.add(alarmSet);

        topAlarmButtons.add(alarmHourUp);
        topAlarmButtons.add(alarmMinuteUp);

        bottomAlarmButtons.add(alarmHourDown);
        bottomAlarmButtons.add(alarmMinuteDown);

        alarmContainer.add(alarmTime);


        tabbedPane.addTab("Clock", clockPanel);
        tabbedPane.addTab("Alarm", alarmPanel);


        frame.add(tabbedPane);


        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void updateTime(long currentTimeMs) {
        timeAsDate = new Date(currentTimeMs);
        readableTime = sdf.format(timeAsDate);
        time.setText(readableTime);
        frame.repaint();
        frame.pack();
    }

    public void activateAlarm(){
        JFrame alertWindow = new JFrame();
        JLabel alert = new JLabel("Alarm Passed!");
        alertWindow.add(alert);
        alertWindow.setVisible(true);
    }

}
