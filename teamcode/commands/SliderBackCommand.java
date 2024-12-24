package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.SliderSubsystem;

public class SliderBackCommand extends CommandBase {
    private final SliderSubsystem sliderSubsystem;

    public SliderBackCommand(SliderSubsystem subsystem) {
        sliderSubsystem = subsystem;
        addRequirements(sliderSubsystem); // Bu komut SliderSubsystem'i kullanır

    }

    @Override
    public void initialize() {

        sliderSubsystem.moveSlider(-1); // Slider aşağı hareket eder (güç ayarlanabilir)
    }

    @Override
    public void end(boolean interrupted) {
        sliderSubsystem.stopSlider(); // Komut sona erince slider durur
    }

}