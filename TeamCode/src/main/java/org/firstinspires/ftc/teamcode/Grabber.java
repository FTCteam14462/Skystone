package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.configuration.typecontainers.ServoConfigurationType;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

public class Grabber {

    CRServo leftGrabber = null;
    CRServo rightGrabber = null;

    public void initialize(CRServo left, CRServo right)
    {
        leftGrabber = left;
        rightGrabber = right;
        stop();
    }

    public void grip(double position)
    {
        leftGrabber.setPower(position);
        rightGrabber.setPower(position);
    }

    public  void release(double position)
    {
        leftGrabber.setPower(position*-1);
        rightGrabber.setPower(position*-1);
    }

    public void stop()
    {
        leftGrabber.setPower(0);
        rightGrabber.setPower(0);
    }
}
