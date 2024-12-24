package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class ArmUpCommand extends CommandBase {

    private final ArmSubsystem armSubsystem;

    public ArmUpCommand(ArmSubsystem subsystem) {
        armSubsystem = subsystem;

        // Declare subsystem dependencies
        addRequirements(armSubsystem);
    }

    @Override
    public void execute() {
        // Set the arm motor to move upwards
        armSubsystem.GoUp();
    }

    @Override
    public void end(boolean interrupted) {

        armSubsystem.stop();
    }
}
