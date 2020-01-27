package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name="Basic: Iterative OpMode Servo Test", group="Iterative Opmode")
//@Disabled
public class BasicOpMode_ServoTest extends OpMode {
    private Servo servo1 = null;
    //private ServoController servoController = null;
    private DcMotor motor = null;
    private DcMotor motor2 = null;
    private TouchSensor touchSensor = null;
    private int i = 0;
    private double power = 0;
    @Override
    public void init() {
        servo1 = hardwareMap.get(Servo.class, "servo1");
        motor = hardwareMap.get(DcMotor.class, "leftFeeder");
        motor2 = hardwareMap.get(DcMotor.class, "rightFeeder");
        //touchSensor = hardwareMap.touchSensor.get("touch1");
        //servoController = servo1.getController();
        //servoController.pwmEnable();

        //servoController.getPwmStatus();
        //servo1.setDirection(Servo.Direction.FORWARD);
        //servo1.scaleRange(0.0,1.0);
        //telemetry.addData("pwmstatus ",servoController.getPwmStatus());
        //telemetry.addData("servo position", servo1.getPosition());
        telemetry.update();
        motor.setDirection(DcMotor.Direction.FORWARD);
        motor2.setDirection(DcMotor.Direction.REVERSE);
        motor.setPower(0);
        motor2.setPower(0);

    }

    public void setPower(double power)
    {
        motor.setPower(power);
        motor2.setPower(power);
    }


    @Override
    public void loop() {
        i++;

        if (i == 500){
            //servoController.setServoPosition(3,.5);
            servo1.setPosition(.5);
            telemetry.addData("servo position ", "Set position");
        }
        else if (i == 600) {
            //servo1.setDirection(Servo.Direction.REVERSE);

            servo1.setPosition(0.3);
            telemetry.addData("servo position ", "reset position");
        }
        telemetry.update();

    }

    //@Override
    public void loop1() {
        i++;

        //if(touchSensor.isPressed()) {
        //    telemetry.addData("digitalSensorPressed", "Is Pressed");
        //    power = .30;
        //}
        // else {
        telemetry.addData("digitalSensorPressed", "Is Not Pressed");
        power= .3;
        // }
        // if (i % 6 == 0) {
        telemetry.addData("motor ", power);
        setPower(power);
        // }
        // else {
        //      telemetry.addData("motor ", "off");
        //     setPower(0);
        // }
        //telemetry.addData("i", i);

        telemetry.update();

    }

}
