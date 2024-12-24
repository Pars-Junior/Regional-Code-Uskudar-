package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

public class HookSubsystem extends SubsystemBase {
    private final Servo arm1Servo;
    private final Servo arm2Servo;

    public HookSubsystem(HardwareMap hardwareMap) {
        arm1Servo = hardwareMap.get(Servo.class, "arm1servo");
        arm2Servo = hardwareMap.get(Servo.class, "arm2servo");
        arm2Servo.setDirection(Servo.Direction.REVERSE);
    }

    public void Open() {

        arm1Servo.setPosition(0);
        arm2Servo.setPosition(0);
    }

    public void Close() {

        arm1Servo.setPosition(0.5);
        arm2Servo.setPosition(0.5);
    }
}
