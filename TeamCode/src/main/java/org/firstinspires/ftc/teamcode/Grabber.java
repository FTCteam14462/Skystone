package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.configuration.typecontainers.ServoConfigurationType;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

public class Grabber {

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.configuration.typecontainers.ServoConfigurationType;
//import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

    public class Grabber {

        Servo leftGrabber = null;
        Servo rightGrabber = null;

        public void initialize(Servo left, Servo right)
        {
            leftGrabber = left;
            rightGrabber = right;
            stop();
        }

        public void grip(double position)
        {
            //leftGrabber.setPower(position);
            //rightGrabber.setPower(position*-1);
            leftGrabber.setPosition(position);
            rightGrabber.setPosition(position*-1);
        }

        public  void release(double position)
        {
            //leftGrabber.setPower(position*-1);
            //rightGrabber.setPower(position);
            leftGrabber.setPosition(position*-1);
            rightGrabber.setPosition(position);
        }

        public void stop()
        {
            //leftGrabber.setPower(0);
            //rightGrabber.setPower(0);
            leftGrabber.setPosition(0);
            rightGrabber.setPosition(0);
        }
    }
}
