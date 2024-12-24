package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.HookSubsystem;

public class CloseClampsCommand extends CommandBase {
    private final HookSubsystem hookSubsystem;

    public CloseClampsCommand(HookSubsystem subsystem) {
        hookSubsystem = subsystem;
        addRequirements(hookSubsystem);
    }

    @Override
    public void initialize() {
        hookSubsystem.Close();
    }

    @Override
    public void end(boolean interrupted) {
        // Pass
    }


}
