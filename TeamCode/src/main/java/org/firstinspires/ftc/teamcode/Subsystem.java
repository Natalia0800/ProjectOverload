package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.ArrayList;

/**
 * This is the Subsystem class for Project Overload. This class represents individual subsystems
 * present on a robot, able to run individual processes and handle basic motion and inverse
 * kinematics.
 *
 * @author Asher Childress - 9161 Overload
 */

public class Subsystem {
    private boolean isBusy;

    private ArrayList<Process> queue = new ArrayList<>();

    private ArrayList<DcMotorEx> motors = new ArrayList<>();
    private ArrayList<HardwareDevice> devices = new ArrayList<>();
    private ArrayList<Servo> servos = new ArrayList<>();
}
