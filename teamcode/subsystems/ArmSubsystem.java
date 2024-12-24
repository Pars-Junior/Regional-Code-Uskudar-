package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.arcrobotics.ftclib.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

    private final DcMotor armMotor;

    public ArmSubsystem(HardwareMap hardwareMap) {
        // Initialize the motor from the hardware map
        armMotor = hardwareMap.get(DcMotor.class, "ArmMotor");

        // Set initial motor direction and brake behavior
        armMotor.setDirection(DcMotor.Direction.FORWARD);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    // Method to control the power of the arm
    public void GoUp() {
        armMotor.setPower(0.6);
    }

    public void GoDown(){
        armMotor.setPower(-0.6);
    }

    // Optional: Method to stop the arm
    public void stop() {
        armMotor.setPower(0);
    }
}
