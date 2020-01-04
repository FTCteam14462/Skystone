package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.CRServo;

public class ColorFinder {
    RevColorSensorV3 sensorColor = null;

    public void initialize(RevColorSensorV3 sColor)
    {
        sensorColor = sColor;
    }

    public boolean isBlackBlock()
    {
        return sensorColor.alpha() < 351 && sensorColor.alpha() > 300
                && sensorColor.red() < 100 && sensorColor.red() > 70
                && sensorColor.green() < 170 && sensorColor.green() > 150
                && sensorColor.blue() < 95 && sensorColor.blue() > 75;

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


