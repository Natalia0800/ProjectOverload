package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.ArrayList;
import java.util.LinkedList;

public class SwerveDrivetrain extends DrivetrainSubsystem {
  private ArrayList<PDFLController> PDFLController;
  
  public SwerveDrivetrain(ArrayList<PDFLController> PDFLController, ArrayList<DcMotorEx> motors, ArrayList<Servo> servos, double[] position) {
    super(motors, servos, position); 
    this.PDFLController = PDFLController;
    
  }
}
