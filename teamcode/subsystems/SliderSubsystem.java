package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.arcrobotics.ftclib.command.SubsystemBase;

public class SliderSubsystem extends SubsystemBase {
    private final DcMotor sliderMotor;

    public SliderSubsystem(HardwareMap hardwareMap) {
        sliderMotor = hardwareMap.get(DcMotor.class, "Slider");
        // Motor fren davranışı
    }

    public void moveSlider(double power) {
        sliderMotor.setPower(power); // Belirtilen güçte slider'ı hareket ettir
    }



    public void stopSlider() {
        sliderMotor.setPower(0); // Slider'ı durdur
    }
}
