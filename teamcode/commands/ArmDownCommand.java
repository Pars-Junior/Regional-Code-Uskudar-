package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class ArmDownCommand extends CommandBase {

    private final ArmSubsystem armSubsystem;

    public ArmDownCommand(ArmSubsystem subsystem) {
        armSubsystem = subsystem;

        // Declare subsystem dependencies
        addRequirements(armSubsystem);
    }

    @Override
    public void execute() {

        armSubsystem.GoDown();
    }

    @Override
    public void end(boolean interrupted) {
        // Stop the motor when the command ends
        armSubsystem.stop();
    }
}