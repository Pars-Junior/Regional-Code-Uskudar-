package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SliderSubsystem;

public class TakeWhellCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;

    public TakeWhellCommand(IntakeSubsystem subsystem) {
        intakeSubsystem = subsystem;
        addRequirements(intakeSubsystem); // Bu komut SliderSubsystem'i kullanır

    }

    @Override
    public void initialize() {


        // Ag götten
        intakeSubsystem.intakeTake(); // Slider aşağı hareket eder (güç ayarlanabilir)
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.WheelsStop(); // Komut sona erince slider durur
    }

}