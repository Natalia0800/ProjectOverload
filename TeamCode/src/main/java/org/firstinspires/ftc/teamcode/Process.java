package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This is the Process class for Project Overload. This class represents processes that can
 * be run by subsystems, allowing subsystems to properly handle object dependencies as well
 * as properly queue multiple processes.
 *
 * @author Asher Childress - 9161 Overload
 */
public class Process {

    private ArrayList<DcMotorEx> motors = new ArrayList<>();
    private ArrayList<HardwareDevice> devices = new ArrayList<>();
    private ArrayList<Servo> servos = new ArrayList<>();
    
    public Process(ArrayList<HardwareDevice> devices, ArrayList<DcMotorEx> motors, ArrayList<Servo> servos) {
        this.devices = devices;
        this.motors = motors;
        this.servos = servos;
    }
    //Hi
    

}
