package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Lifter {

    DcMotor leftLifter = null;
    DcMotor rightLifter = null;
    double fastSpeed = 0;
    double slowSpeed = 0;

    public void initialize(DcMotor left, DcMotor right, int stoppostion, double fast, double slow)
    {
        leftLifter = left;
        rightLifter = right;
        fastSpeed = fast;
        slowSpeed = slow;

        leftLifter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightLifter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        leftLifter.setDirection(DcMotor.Direction.REVERSE);
        rightLifter.setDirection(DcMotor.Direction.REVERSE);

        rightLifter.setTargetPosition(stoppostion);

    }

    public void placeBlock(double speed)
    {

        if (rightLifter.getCurrentPosition() < 110)
        {
            leftLifter.setPower(speed);
            rightLifter.setPower(speed);
        }
        else if (rightLifter.getCurrentPosition() < 195)
        {
            leftLifter.setPower(speed);
            rightLifter.setPower((speed));
        }
        else
        {
            leftLifter.setPower(0);
            rightLifter.setPower(0);

            rightLifter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftLifter.setDirection(DcMotor.Direction.FORWARD);
            rightLifter.setDirection(DcMotor.Direction.FORWARD);
        }
    }

    public void returnForBlock(double speed)
    {
        if (rightLifter.getCurrentPosition() > 85)
        {
            leftLifter.setPower(speed);
            rightLifter.setPower(speed);
        }
        else if (rightLifter.getCurrentPosition() > 10)
        {
            leftLifter.setPower(speed);
            rightLifter.setPower(speed);
        }
        else
        {
            leftLifter.setPower(0);
            rightLifter.setPower(0);

            rightLifter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftLifter.setDirection(DcMotor.Direction.FORWARD);
            rightLifter.setDirection(DcMotor.Direction.FORWARD);
        }
    }
}
