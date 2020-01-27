package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Feeder {
    private DcMotor leftFeeder = null;
    private DcMotor rightFeeder = null;
    private ElapsedTime runtime = new ElapsedTime();


    public void initialize(DcMotor left_Feeder, DcMotor right_Feeder)
    {
        leftFeeder = left_Feeder;
        rightFeeder = right_Feeder;

        leftFeeder.setDirection(DcMotor.Direction.REVERSE);
        rightFeeder.setDirection(DcMotor.Direction.FORWARD);

        this.stop();
    }

    public void stop(){
        leftFeeder.setPower(0.0);
        rightFeeder.setPower(0.0);
    }

    public void intake(double power){
        leftFeeder.setDirection(DcMotor.Direction.REVERSE);
        rightFeeder.setDirection(DcMotor.Direction.FORWARD);

        leftFeeder.setPower(power);
        rightFeeder.setPower(power);
    }

    public void release (double power){
        leftFeeder.setDirection(DcMotor.Direction.FORWARD);
        rightFeeder.setDirection(DcMotor.Direction.REVERSE);

        leftFeeder.setPower(power);
        rightFeeder.setPower(power);
    }
}
