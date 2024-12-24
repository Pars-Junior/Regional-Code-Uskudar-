package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ElevatorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SliderSubsystem;

public class ElevatorOrta extends CommandBase {
    private final ElevatorSubsystem elevatorSubsystem;

    public ElevatorOrta(ElevatorSubsystem subsystem) {
        elevatorSubsystem = subsystem;
        addRequirements(elevatorSubsystem); // Bu komut SliderSubsystem'i kullanır

    }

    @Override
    public void initialize() {


        // Ag götten
        elevatorSubsystem.moveUpElevator(-1000); // Slider aşağı hareket eder (güç ayarlanabilir)
    }

    @Override
    public void end(boolean interrupted) {
        //  elevatorSubsystem.stop(); // Komut sona erince slider durur
    }

}