package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ElevatorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SliderSubsystem;

public class ElevatorDownCommand extends CommandBase {
    private final ElevatorSubsystem elevatorSubsystem;

    public ElevatorDownCommand(ElevatorSubsystem subsystem) {
        elevatorSubsystem = subsystem;
        addRequirements(elevatorSubsystem); // Bu komut SliderSubsystem'i kullanır

    }

    @Override
    public void initialize() {


        // Ag götten
        elevatorSubsystem.moveDownElevator(-230); // Slider aşağı hareket eder (güç ayarlanabilir)
    }

    @Override
    public void end(boolean interrupted) {
       // elevatorSubsystem.stop(); // Komut sona erince slider durur
    }

}