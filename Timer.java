package org.firstinspires.ftc.teamcode.POPlaneFiles;

public class Timer {

    private long startTime;


    public Timer() {reset();}

    public void reset() {
        startTime = System.nanoTime();
    }

    public long getTime() {
        return System.nanoTime() - startTime;
    }

    public double getTimeSeconds() {
        return (getTime()/ Math.pow(10.0,9));
    }
}
