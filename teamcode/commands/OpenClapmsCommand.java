package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.HookSubsystem;

public class OpenClapmsCommand extends CommandBase {
    private final HookSubsystem hookSubsystem;

    public OpenClapmsCommand(HookSubsystem subsystem) {
        hookSubsystem = subsystem;
        addRequirements(hookSubsystem);
    }

    @Override
    public void initialize() {
        hookSubsystem.Open();
    }

    @Override
    public void end(boolean interrupted) {
        // Pass
    }


}
