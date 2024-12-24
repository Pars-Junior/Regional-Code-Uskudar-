package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

public class supurge_kapat_command extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;

    public supurge_kapat_command(IntakeSubsystem subsystem) {
        intakeSubsystem = subsystem;
        addRequirements(intakeSubsystem); // Bu komut SliderSubsystem'i kullanır

    }

    @Override
    public void initialize() {

        intakeSubsystem.supurge_kapat(); // Slider aşağı hareket eder (güç ayarlanabilir)
    }

    @Override
    public void end(boolean interrupted) {

    }

}