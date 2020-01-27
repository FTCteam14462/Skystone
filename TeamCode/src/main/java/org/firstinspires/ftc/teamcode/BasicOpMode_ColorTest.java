package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.Locale;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import com.qualcomm.robotcore.hardware.TouchSensor;
import android.graphics.Color;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name="Basic: ColorTest", group="Iterative Opmode")
//@Disabled
public class BasicOpMode_ColorTest extends OpMode {
    private RevColorSensorV3 sensorColor = null;
    private TouchSensor touchSensor = null;
    private float hsvValues[] = {0F, 0F, 0F};

    // values is a reference to the hsvValues array.
    final float values[] = hsvValues;

    // sometimes it helps to multiply the raw RGB values with a scale factor
    // to amplify/attentuate the measured values.
    final double SCALE_FACTOR = 255;


    @Override
    public void init() {
        sensorColor = hardwareMap.get(RevColorSensorV3 .class,"blockColorSensor");
        touchSensor = hardwareMap.touchSensor.get ("touchSensor");
    }

    @Override
    public void loop() {

        // light = (SwitchableLight) sensorColor;
        //light.enableLight(true);


        // send the info back to driver station using telemetry function.

        telemetry.addData("Alpha", sensorColor.alpha());
        telemetry.addData("Red  ", sensorColor.red());
        telemetry.addData("Green", sensorColor.green());
        telemetry.addData("Blue ", sensorColor.blue());
        telemetry.addData("Hue", hsvValues[0]);

        telemetry.addData("IsBlackBlock", isBlackBlock());
        telemetry.addData("IsYellowBlock", isYellowBlock());
        telemetry.update();


    }

    public boolean isBlackBlock()
    {
        return sensorColor.alpha() < 351 && sensorColor.alpha() > 300
                && sensorColor.red() < 100 && sensorColor.red() > 70
                && sensorColor.green() < 170 && sensorColor.green() > 150
                && sensorColor.blue() < 95 && sensorColor.blue() > 75;

    }

    public boolean isYellowBlock()
    {
        return sensorColor.alpha() < 603 && sensorColor.alpha() > 558
                && sensorColor.red() < 211 && sensorColor.red() > 181
                && sensorColor.green() < 308 && sensorColor.green() > 288
                && sensorColor.blue() <  111 && sensorColor.blue() > 91;

    }


    public boolean isRedLine()
    {
        return sensorColor.alpha() < 420 && sensorColor.alpha() > 360
                && sensorColor.red() < 146 && sensorColor.red() > 126
                && sensorColor.green() < 1194 && sensorColor.green() > 174
                && sensorColor.blue() < 102 && sensorColor.blue() >82;

    }

    public boolean isBlueLine()
    {
        return sensorColor.alpha() < 670 && sensorColor.alpha() > 610
                && sensorColor.red() < 151 && sensorColor.red() > 131
                && sensorColor.green() < 285 && sensorColor.green() > 265
                && sensorColor.blue() < 260 && sensorColor.blue() > 240;

    }
}
