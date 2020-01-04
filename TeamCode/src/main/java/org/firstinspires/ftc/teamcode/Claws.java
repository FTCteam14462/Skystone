package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.configuration.typecontainers.ServoConfigurationType;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

public class Claws {

    CRServo leftClaw = null;
    CRServo rightClaw = null;
    public void initialize(CRServo left, CRServo right)
    {
        leftClaw = left;
        rightClaw = right;
        stop();
    }

    public void grip(double position)
    {
        leftClaw.setPower(position);
        rightClaw.setPower(position);
    }

    public  void release(double position)
    {
        leftClaw.setPower(position*-1);
        rightClaw.setPower(position*-1);
    }

    public void stop()
    {
        leftClaw.setPower(0);
        rightClaw.setPower(0);
    }

}
