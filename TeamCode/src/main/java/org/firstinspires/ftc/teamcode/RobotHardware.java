package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class RobotHardware
{

    /* INSTANTIATE MOTORS AND SERVOS. */
    public DcMotor  rMotor;
    public DcMotor  lMotor1;
    public DcMotor  rMotor2;
    public DcMotor  lMotor3;
    public DcMotor  motorArm;
    public Servo    leftArm;
    public Servo    rightArm;

    /* CREATING THE HARDWARE MAP. */
    HardwareMap hardwareMap;

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap hardwareMap) {
        // Define Motors and Servo
        rMotor = hardwareMap.get(DcMotor.class, "r1");
        lMotor1 = hardwareMap.get(DcMotor.class, "l1");
        rMotor2 = hardwareMap.get(DcMotor.class, "r2");
        lMotor3 = hardwareMap.get(DcMotor.class, "l2");
        motorArm = hardwareMap.get(DcMotor.class, "arm");
        leftArm = hardwareMap.get(Servo.class, "leftclaw");
        rightArm = hardwareMap.get(Servo.class, "rightclaw");

        // Set Motor Power
        rMotor.setPower(0);
        lMotor1.setPower(0);
        rMotor2.setPower(0);
        lMotor3.setPower(0);

        // Set Motor Mode.
        rMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lMotor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set Motor zeroPowerBehavior
        rMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lMotor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Set Servo Position
        leftArm.setPosition(0);
        rightArm.setPosition(0);

    }
}
