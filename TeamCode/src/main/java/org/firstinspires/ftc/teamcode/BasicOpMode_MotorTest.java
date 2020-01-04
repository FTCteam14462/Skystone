package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name="Basic: Iterative OpMode Motor Test", group="Iterative Opmode")
//@Disabled
public class BasicOpMode_MotorTest extends OpMode {
    private DcMotor leftRearDrive = null;
    private DcMotor rightFrontDrive = null;
    private TouchSensor touchSensor = null;
    @Override
    public void init() {
        rightFrontDrive = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        leftRearDrive  = hardwareMap.get(DcMotor.class, "leftRearMotor");
        touchSensor = hardwareMap.touchSensor.get ("touchSensor");

        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftRearDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    private void setPower(double power) {
        rightFrontDrive.setPower(power);
        leftRearDrive.setPower(power);
    }


    @Override
    public void loop() {
        if(touchSensor.isPressed()) {
            telemetry.addData("digitalSensorPressed", "Is Pressed");
            setPower(1);
        }
        else {
            telemetry.addData("digitalSensorPressed", "Is Not Pressed");
            setPower(0);
        }
    }
}
