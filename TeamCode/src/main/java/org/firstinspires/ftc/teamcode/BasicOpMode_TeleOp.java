package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.Timer;
import com.qualcomm.robotcore.hardware.CRServo;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name="TeleOp (AKA: use this one)", group="Iterative Opmode")
//@Disabled
public class BasicOpMode_TeleOp extends OpMode{

    private Grabber grabber = new Grabber();
    private int claw = -1;
    private int grip = -1;
    private boolean gripping = false;
    double latestGrab;
    double grippingTime;
    double releasingTime;
    double latestClaw;
    private Claws claws = new Claws();
    private DriveTrain driveTrain = new DriveTrain();
    private Lifter lifter = new Lifter();
    private Feeder feeder = new Feeder();

    @Override
    public void init() {
        grabber.initialize(hardwareMap.get(Servo.class, "leftGripper"),
                hardwareMap.get(Servo.class, "rightGripper"));
        claws.initialize(hardwareMap.get(Servo.class, "leftClaw"),
                hardwareMap.get(Servo.class, "rightClaw"));
        driveTrain.initialize(hardwareMap.get(DcMotor.class, "leftRearMotor"),
                hardwareMap.get(DcMotor.class, "rightRearMotor"),
                hardwareMap.get(DcMotor.class, "leftFrontMotor"),
                hardwareMap.get(DcMotor.class, "rightFrontMotor"));
        lifter.initialize(hardwareMap.get(DcMotor.class, "leftLifter"),
                hardwareMap.get(DcMotor.class, "rightLifter"),630,0.8,0.4);
        feeder.initialize(hardwareMap.get(DcMotor.class, "leftFeeder"),
                hardwareMap.get(DcMotor.class, "rightFeeder"));
        latestGrab = 0;
        latestClaw = 0;
        grippingTime = 0;
        releasingTime = 0;
    }

    @Override
    public void loop() {
        CheckGrabber();
        //CheckClaws();
        //CheckDrive();
        //CheckFeeder();
        //driveTrain.runLeftRearMotor();
        //driveTrain.runLeftFrontMotor();
        //driveTrain.runRightRearMotor();
        //driveTrain.runRightFrontMotor();

        //driveTrain.drive_forward(0.2);
    }

    public void CheckGrabber()
    {
       /* double now = System.currentTimeMillis();
        if (grippingTime == 0) grippingTime = now;
        if (releasingTime == 0) releasingTime = now;
        //if (gamepad2.left_bumper == true && ((now - latestGrab) > 500))
        if (gamepad2.left_bumper == true )
        {

            latestGrab = now;
            grip = grip +1;
            if (grip == 3)
                grip = -1;
        }
        if (grip == 0 && ((now - grippingTime)) > 1000)
        {
            grabber.grip(.8);
            grippingTime = now;
        }
        else if (grip == 2 && ((now - releasingTime)) > 1000)
        {
            releasingTime = now;
            grabber.release(.8);
        }
        else
        {
            //grabber.stop();
        }*/
        if (gamepad2.x == true) {
            grabber.grip(1);
        }
        if (gamepad2.y ==true) {
            grabber.release(.75);
        }
    }

    public void CheckClaws()
    {
        double nowg = System.currentTimeMillis();

/*        if (gamepad2.right_bumper == true && ((nowg - latestClaw) > 500))
        {
            latestClaw = nowg;
            claw = claw +1;
            if (claw == 3)
                claw = -1;
        }
        if (claw == 0)
            claws.grip(.8);
        else if (claw == 2)
            claws.release(.8);
        else
            claws.stop();*/
        if (gamepad2.a == true) {
            claws.grip(1);
        }
        if (gamepad2.b == true) {
            claws.release(1);
        }
    }
    public void CheckDrive()
    {
        if (gamepad1.x == true){
            driveTrain.turn_right(0.9);
        }
        else if (gamepad1.y == true) {
            driveTrain.turn_left(0.72);
        }
        else
        if (gamepad1.left_stick_y > 0.2){
            driveTrain.drive_backward(gamepad1.left_stick_y * .9);
        }
        else if (gamepad1.left_stick_y < -0.2) {
            driveTrain.drive_forward(gamepad1.left_stick_y * -.9);
        }
        else if (gamepad1.left_stick_x > 0.2) {
            driveTrain.drive_left(gamepad1.left_stick_x * .9);
        }
        else if (gamepad1.left_stick_x < -0.2) {
            driveTrain.drive_right(gamepad1.left_stick_x * -.9);
        }
        else {
            driveTrain.stop();
        }
        /*
        if (gamepad1.x == true){
            driveTrain.drive_forward(0.7);
        }
        else if (gamepad1.y == true) {
            driveTrain.drive_backward(0.7);
        }
        else {
            driveTrain.stop();
        }*/
        telemetry.addData("gamepad1.x  ", gamepad1.x);
        telemetry.addData("gamepad1.y ", gamepad1.y);
        telemetry.update();

    }

    public void Lift() {
        if (gamepad2.right_stick_y > 0) {
            lifter.placeBlock(gamepad2.right_stick_y);
        }
        else if (gamepad2.right_stick_y < 0) {
            lifter.returnForBlock(gamepad2.right_stick_y * -1);
        }

    }

    public void CheckFeeder() {
        if (gamepad2.left_stick_y > 0) {
            feeder.release(gamepad2.right_stick_y);
        }
        else if (gamepad2.left_stick_y < 0) {
            feeder.intake(gamepad2.right_stick_y * -1);
        }

    }
}
