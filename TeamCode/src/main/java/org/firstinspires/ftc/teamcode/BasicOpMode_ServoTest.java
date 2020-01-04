package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
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
    @Override
    public void init() {
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo1.setDirection(Servo.Direction.FORWARD);
        servo1.scaleRange(0.0,0.5);
    }

    @Override
    public void loop() {
        telemetry.addData("servo position", servo1.getPosition());
        telemetry.update();
        servo1.setPosition(.5);
        telemetry.addData("servo position", servo1.getPosition());
        telemetry.update();
    }
}
