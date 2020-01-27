package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name="Auto Red Loading", group="Iterative Opmode")
//@Disabled
public class RedLoading2020 extends OpMode {
    private DriveTrain driveTrain = new DriveTrain();
    private ColorFinder blockfinder = new ColorFinder();
    private DistSensor rightDistance = new DistSensor();
    private DistSensor leftDistance = new DistSensor();
    @Override
    public void init() {
        driveTrain.initialize(hardwareMap.get(DcMotor.class, "leftRearMotor"),
                hardwareMap.get(DcMotor.class, "rightRearMotor"),
                hardwareMap.get(DcMotor.class, "leftFrontMotor"),
                hardwareMap.get(DcMotor.class, "rightFrontMotor"));
        blockfinder.initialize(hardwareMap.get(RevColorSensorV3 .class,"blockColorSensor"));
        rightDistance.initialize(hardwareMap.get(DistanceSensor.class, "rightDistanceSensor"));
        leftDistance.initialize(hardwareMap.get(DistanceSensor.class, "leftDistanceSensor"));
    }

    @Override
    public void loop() {

    }
}
