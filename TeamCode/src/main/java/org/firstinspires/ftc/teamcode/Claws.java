package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.configuration.typecontainers.ServoConfigurationType;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

public class Claws {

    Servo leftClaw = null;
    Servo rightClaw = null;
    public void initialize(Servo left, Servo right)
    {
        leftClaw = left;
        rightClaw = right;
        stop();
    }

    public void grip(double position)
    {
        leftClaw.setPosition(position*-1);
        rightClaw.setPosition(position);
    }

    public  void release(double position)
    {
        leftClaw.setPosition(position);
        rightClaw.setPosition(position*-1);
    }

    public void stop()
    {
        leftClaw.setPosition(0);
        rightClaw.setPosition(0);
    }

}
