package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name="Auto Blue Build", group="Iterative Opmode")
//@Disabled
public class BlueBuilder2020 extends OpMode {
    private DriveTrain driveTrain = new DriveTrain();
    private ColorFinder linefinder = new ColorFinder();
    private DistSensor rightDistance = new DistSensor();
    private DistSensor leftDistance = new DistSensor();
    private DistSensor forwardDistance = new DistSensor();
    private Claws claws = new Claws();
    private double steptime;
    int step = 1;

    @Override
    public void init() {
        claws.initialize(hardwareMap.get(Servo.class, "leftClaw"),
                hardwareMap.get(Servo.class, "rightClaw"));
        driveTrain.initialize(hardwareMap.get(DcMotor.class, "leftRearMotor"),
                hardwareMap.get(DcMotor.class, "rightRearMotor"),
                hardwareMap.get(DcMotor.class, "leftFrontMotor"),
                hardwareMap.get(DcMotor.class, "rightFrontMotor"));
        linefinder.initialize(hardwareMap.get(RevColorSensorV3 .class,"bottomColorSensor"));
        rightDistance.initialize(hardwareMap.get(DistanceSensor.class, "rightDistanceSensor"));
        leftDistance.initialize(hardwareMap.get(DistanceSensor.class, "leftDistanceSensor"));
        forwardDistance.initialize(hardwareMap.get(DistanceSensor.class, "forwardDistanceSensor"));
    }

    @Override
    public void loop() {
        double now = System.currentTimeMillis();
        switch (step){
            case 1:
                if (forwardDistance.getDistanceInches()< 24){
                    driveTrain.drive_backward(0.4);
                }
                else {
                    driveTrain.stop();
                    step = 2;
                    steptime = now;
                }
                break;
            case 2:
                if((now - steptime) < 1000 ) {
                    claws.grip(0.5);
                }
                else {
                    step =3;
                }
                break;
            case 3:
                claws.stop();
                steptime = 0;
                if (forwardDistance.getDistanceInches() > 2){
                    driveTrain.drive_forward(0.5);
                }
                else {
                    driveTrain.stop();
                    steptime = now;
                    step = 4;
                }
                break;

            case 4:
                if((now - steptime) < 1000 ) {
                    claws.release(0.5);
                }
                else {
                    step = 5;
                }
                break;

            case 5:
                claws.stop();
                steptime = 0;
                if (forwardDistance.getDistanceInches() > 2){
                    driveTrain.drive_forward(0.5);
                }
                else {
                    driveTrain.stop();
                    step = 6;
                }
                break;

            case 6:
                if (rightDistance.getDistanceInches() < 63 && linefinder.isBlueLine()){
                    driveTrain.drive_left(0.5);
                }
                else {
                    driveTrain.stop();
                    step = 7;
                }
                break;

            default: stop();
        }
    }
}