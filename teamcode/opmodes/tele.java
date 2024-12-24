package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Try")
public class tele extends LinearOpMode {

    private DcMotor intake;



    @Override
    public void runOpMode() {
        intake = hardwareMap.get(DcMotor.class, "kol1");

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad2.right_bumper) {
                intake.setPower(0.7);
            }
            else if (gamepad2.left_bumper) {
                intake.setPower(-0.7);
            }
            else {
                intake.setPower(0);
            }
        }
    }
}
