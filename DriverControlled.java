package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="DriverControlled", group="TeleOp")

public class DriverControlled extends LinearOpMode {

    /* Define Robot. */
    RobotHardware robot = new RobotHardware();

    // Constants
    ElapsedTime runtime = new ElapsedTime();
    DcMotor rMotor;
    DcMotor lMotor1;
    DcMotor rMotor2;
    DcMotor lMotor3;
    DcMotor motorArm;
    Servo leftArm;
    Servo rightArm;


    @Override
    public void runOpMode() {
        //Left Back Motor
        lMotor3 = hardwareMap.get(DcMotor.class, "l2");
        lMotor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lMotor3.setDirection(DcMotor.Direction.FORWARD);
        //Right Back
        rMotor2 = hardwareMap.get(DcMotor.class, "r2");
        rMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rMotor2.setDirection(DcMotor.Direction.REVERSE);
        //Left Front
        lMotor1 = hardwareMap.get(DcMotor.class, "l1");
        lMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lMotor1.setDirection(DcMotor.Direction.FORWARD);
        //Right Front
        rMotor = hardwareMap.get(DcMotor.class, "r1");
        rMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rMotor.setDirection(DcMotor.Direction.REVERSE);
        // Arm Motor
        motorArm = hardwareMap.get(DcMotor.class, "arm");
        motorArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorArm.setDirection(DcMotor.Direction.FORWARD);

        leftArm = hardwareMap.servo.get("leftclaw");
        rightArm = hardwareMap.servo.get("rightclaw");

        double speedAdjust = 7;

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            if (gamepad1.dpad_left) {
                speedAdjust -= 1;
            }
            if (gamepad1.dpad_right) {
                speedAdjust += 1;
            }
            lMotor3.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x)*(-speedAdjust/10));
            rMotor2.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x)*(-speedAdjust/10));
            lMotor1.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*(-speedAdjust/10));
            rMotor.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x)*(-speedAdjust/10));

            if (gamepad1.right_bumper) {
                leftArm.setPosition(1);
                rightArm.setPosition(1);
            }
            if (gamepad1.left_bumper) {
                leftArm.setPosition(-1);
                rightArm.setPosition(-1);
            }


            telemetry.addData("Speed Adjust", speedAdjust);
        }
    }
}

