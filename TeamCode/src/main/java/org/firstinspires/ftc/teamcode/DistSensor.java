package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class DistSensor {
    private DistanceSensor distanceSensor = null;

    public void initialize(DistanceSensor dSensor){

        distanceSensor = dSensor;
    }

    public double getDistanceInches()
    {
        return distanceSensor.getDistance(DistanceUnit.INCH);
    }
}
