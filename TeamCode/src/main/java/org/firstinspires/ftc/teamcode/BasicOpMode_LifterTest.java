package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Basic: Iterative OpMode Lifter Test", group="Iterative Opmode")
//@Disabled
public class BasicOpMode_LifterTest extends OpMode {
    private int i = 0;
    private DcMotor rightLifter = null;
    private DcMotor leftLifter = null;
    private DcMotor testMotor = null;
    private TouchSensor touchSensor = null;
    private Servo gripLeft = null;
    private Servo gripRight = null;

    @Override
    public void init() {
        //touchSensor = hardwareMap.touchSensor.get("touch1");
        testMotor  = hardwareMap.get(DcMotor.class, "testmotor");
        leftLifter  = hardwareMap.get(DcMotor.class, "leftLifter");
        rightLifter = hardwareMap.get(DcMotor.class, "rightLifter");
        gripLeft = hardwareMap.get(Servo.class, "leftGripper");
        gripRight = hardwareMap.get(Servo.class, "rightGripper");

        gripLeft.setDirection(Servo.Direction.REVERSE);
        gripRight.setDirection(Servo.Direction.FORWARD);

        gripRight.scaleRange(0.0,1.0);
        gripLeft.scaleRange(0.0,1.0);

        //leftLifter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //rightLifter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //leftLifter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //rightLifter.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //testMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //testMotor.setTargetPosition(500);

        //leftLifter.setDirection(DcMotor.Direction.REVERSE);
        //rightLifter.setDirection(DcMotor.Direction.REVERSE);
        //leftLifter.setDirection(DcMotor.Direction.FORWARD);
        //rightLifter.setDirection(DcMotor.Direction.FORWARD);
        //testMotor.setDirection(DcMotor.Direction.FORWARD);

        //leftLifter.setTargetPosition(5000);
        //rightLifter.setTargetPosition(200);
    }


    @Override
    public void loop(){

        i++;
        if (i == 500)
        {
            gripLeft.setPosition(.8);
            gripRight.setPosition(.8);

            telemetry.addData("Gripping", "true");
        }
        else if (i == 1000){


            gripLeft.setPosition(0);
            gripRight.setPosition(0);
            telemetry.addData("Gripping", "false");
        }
        telemetry.update();

    }

    public void loop1() {
        //testMotor.setPower(.6);
        /*if(touchSensor.isPressed()) {
            telemetry.addData("digitalSensorPressed", "Is Pressed");
            leftLifter.setDirection(DcMotor.Direction.REVERSE);
            rightLifter.setDirection(DcMotor.Direction.REVERSE);
        }
        else {
            telemetry.addData("digitalSensorPressed", "Is Not Pressed");
            leftLifter.setDirection(DcMotor.Direction.FORWARD);
            rightLifter.setDirection(DcMotor.Direction.FORWARD);
        }*/
        telemetry.addData("Right Position", rightLifter.getCurrentPosition());
        //telemetry.addData("Leftt Position", leftLifter.getCurrentPosition());
        telemetry.addData("Test Position", testMotor.getCurrentPosition());

       /* if (rightLifter.getCurrentPosition() > 5000 ||
        leftLifter.getCurrentPosition() > 5000 )
        {
             set_lifter_power(0);

        }
        else {*/
        //left
        if (rightLifter.getCurrentPosition() < 110)
        {
            set_lifter_power(.5);
        }
        else if (rightLifter.getCurrentPosition() < 195) {
            set_lifter_power(.25);
        }
        else
        {
            set_lifter_power(0);
            rightLifter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightLifter.setDirection(DcMotor.Direction.FORWARD);
            leftLifter.setDirection(DcMotor.Direction.FORWARD);
        }

        telemetry.update();
    }

    public void set_lifter_power(double power)
    {
        leftLifter.setPower(power);
        rightLifter.setPower(power);
    }
}
