package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class DriveTrain {
    private DcMotor leftRearDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightRearDrive = null;
    private DcMotor leftFrontDrive = null;
    private ElapsedTime runtime = new ElapsedTime();


    public void initialize(DcMotor leftRear, DcMotor rightRear, DcMotor leftFront, DcMotor rightFront)
    {
        leftRearDrive = leftRear;
        rightRearDrive = rightRear;
        leftFrontDrive = leftFront;
        rightFrontDrive = rightFront;

        leftRearDrive.setDirection(DcMotor.Direction.REVERSE);
        rightRearDrive.setDirection(DcMotor.Direction.FORWARD);
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        this.stop();
    }

    public void runLeftRearMotor()
    {
        leftRearDrive.setPower(.5);
    }

    public void runLeftFrontMotor()
    {
        leftFrontDrive.setPower(.5);
    }
    public void runRightRearMotor()
    {
        rightRearDrive.setPower(.5);
    }
    public void runRightFrontMotor()
    {
        rightFrontDrive.setPower(.5);
    }

    public void set_drive_power(double power)
    {
        rightFrontDrive.setPower(power);
        leftFrontDrive.setPower(power);
        rightRearDrive.setPower(power*1.08);
        leftRearDrive.setPower(power);
    }

    public void drive_forward() {
        //leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftRearDrive.setDirection(DcMotor.Direction.REVERSE);
        rightRearDrive.setDirection(DcMotor.Direction.FORWARD);
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
    }


    public void drive_forward(double power)
    {
        set_drive_power(power);
        drive_forward();
    }
    //                                                         HEMLO 14
    public void drive_forward(double power, double time)
    {
        double currentTime = runtime.time();
        while((runtime.time()- currentTime) < time)
        {
            drive_forward(power);
        }
    }
    //                                                          HEMLO 15
    public void drive_backward()
    {
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftRearDrive.setDirection(DcMotor.Direction.FORWARD);
        rightRearDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);

    }

    public void drive_backward(double power)
    {
        set_drive_power(power);
        drive_backward();
    }

    public void drive_backward(double power, double time)
    {
        double currentTime = runtime.time();
        while((runtime.time()- currentTime) < time)
        {
            drive_backward(power);
        }
    }

    public void drive_right()
    {
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftRearDrive.setDirection(DcMotor.Direction.REVERSE);
        rightRearDrive.setDirection(DcMotor.Direction.REVERSE);

    }

    public void drive_right(double power)
    {
        set_drive_power(power);
        drive_right();
    }

    public void drive_right(double power, double time)
    {
        double currentTime = runtime.time();
        while((runtime.time()- currentTime) < time)
        {
            drive_right(power);
        }
    }

    public void drive_left()
    {
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftRearDrive.setDirection(DcMotor.Direction.FORWARD);
        rightRearDrive.setDirection(DcMotor.Direction.FORWARD);

    }

    public void drive_left(double power)
    {
        set_drive_power(power);
        drive_left();
    }

    public void drive_left(double power, double time)
    {
        double currentTime = runtime.time();
        while((runtime.time()- currentTime) < time)
        {
            drive_left(power);
        }
    }

    public void turn_left()
    {
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftRearDrive.setDirection(DcMotor.Direction.REVERSE);
        rightRearDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    public void turn_left(double power)
    {
        set_drive_power(power);
        turn_left();
    }

    public void turn_left (double power, double time)
    {
        double currentTime = runtime.time();
        while((runtime.time()- currentTime) < time)
        {
            turn_left(power);
        }
    }

    public void turn_right()
    {
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftRearDrive.setDirection(DcMotor.Direction.FORWARD);
        rightRearDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    public void turn_right(double power)
    {
        set_drive_power(power);
        turn_right();
    }

    public void turn_right (double power, double time)
    {
        double currentTime = runtime.time();
        while((runtime.time()- currentTime) < time)
        {
            turn_right(power);
        }
    }

    public void stop()
    {
        set_drive_power(0.0);
    }
}
