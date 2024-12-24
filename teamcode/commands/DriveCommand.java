package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import com.qualcomm.robotcore.hardware.Gamepad;

public class DriveCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final Gamepad gamepad;

    public DriveCommand(DriveSubsystem driveSubsystem, Gamepad gamepad) {
        this.driveSubsystem = driveSubsystem;
        this.gamepad = gamepad;
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        double drive = gamepad.left_stick_y;
        double strafe = -gamepad.left_stick_x;
        double twist = -gamepad.right_stick_x;

        driveSubsystem.manualDrive(drive, strafe, twist);
    }
}