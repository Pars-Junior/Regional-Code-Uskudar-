package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.SliderSubsystem;

public class SliderBackSlow extends CommandBase {
    private final SliderSubsystem sliderSubsystem;

    public SliderBackSlow(SliderSubsystem subsystem) {
        sliderSubsystem = subsystem;
        addRequirements(sliderSubsystem);
    }

    @Override
    public void initialize() {
        sliderSubsystem.moveSlider(0.4);
    }

    @Override
    public void end(boolean interrupted) {
        sliderSubsystem.stopSlider();
    }


}
