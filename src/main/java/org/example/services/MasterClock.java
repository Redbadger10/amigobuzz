package org.example.services;

import org.example.GUI;
import org.example.UpdateIF;
import org.zeromq.SocketType;
import org.zeromq.ZConfig;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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
    long alarmTimeMs;

    public void start(){




            Timer time = new Timer();

            UpdateIF[] services_ibe = {new CheckAlarms(), GUI.getInstance()};
            System.out.println("here idjit");
            time.schedule(new TimerTask() {
                private final static ZContext context = new ZContext();;
                private final static ZMQ.Socket socket = context.createSocket(SocketType.REQ);

                static {
                    socket.connect("tcp://localhost:5555");
                }
                @Override
                public void run() {
                    long currentTimeMs = System.currentTimeMillis();
                    //System.out.println(System.currentTimeMillis());
                    for (UpdateIF updateIF : services_ibe) {
                        updateIF.updateTime(currentTimeMs + offset);
                    }

                    String request = Long.toString(alarmTimeMs);
                    socket.send(request.getBytes(ZMQ.CHARSET), 0);

                    String reply = new String(socket.recv(0), ZMQ.CHARSET);
                    System.out.println(reply);
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

    public void setAlarm(long newTime){
        alarmTimeMs = newTime;
    }



}
