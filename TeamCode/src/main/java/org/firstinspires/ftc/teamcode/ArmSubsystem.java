package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArmSubsystem extends Subsystem {
    private ArrayList<PDFLController> PDFLController;
    
    public ArmSubsystem(ArrayList<PDFLController> PDFLController, ArrayList<HardwareDevice> devices, ArrayList<DcMotorEx> motors, ArrayList<Servo> servos, double[] position) {
      super(devices, motors, servos, position);
      this.PDFLController = PDFLController;
      
    }
}
