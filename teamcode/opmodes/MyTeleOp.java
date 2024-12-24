package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.RobotContainer;
import org.firstinspires.ftc.teamcode.subsystems.ElevatorSubsystem;


@TeleOp(name = "Command-Based TeleOp")
public class MyTeleOp extends LinearOpMode {
    private  RobotContainer robotContainer;

    private DcMotor elevator;

    @Override
    public void runOpMode() {
        robotContainer = new RobotContainer(hardwareMap, gamepad1, gamepad2);
        robotContainer.configureBindings();
        elevator = hardwareMap.get(DcMotor.class, "elevator");
        elevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



        waitForStart();


        while (opModeIsActive()) {
            robotContainer.run();


        }
    }
}
