package org.firstinspires.ftc.teamcode;

/**
 * This is a PDFL class intended for use in Project Overload. The PDFL controller handles
 * the running of a PDF Controller, with an added lower limit, L, to prevent undercorrection
 * due to friction inherent in systems.
 *
 * @ author Asher Childress - 9161 Overlaod
 */

public class PDFLController {

    private double p,d,f,l;

    private double position, target, error, oldError, dError;

    private long time, oldTime;


    public PDFLController(double p,double d,double f,double l) {
        this.p = p;
        this.d = d;
        this.f = f;
        this.l = l;
    }

    public double runPDFL() {
        double returnVal = error*p + dError*d + f;

        return Math.max(l, Math.abs(returnVal)) * returnVal/Math.abs(returnVal);
    }

    public void update(double position) {
        oldError = error;
        error = target-position;

        oldTime = time;
        time = System.nanoTime();

        dError = (error-oldError) /((time-oldTime)/ Math.pow(10.0,9));
    }


    public void setTarget(double target) {this.target = target;}
}
