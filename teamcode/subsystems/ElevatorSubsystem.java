package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ElevatorSubsystem extends SubsystemBase {
    private final DcMotor elevator;

    public ElevatorSubsystem(HardwareMap hardwareMap) {
        elevator = hardwareMap.get(DcMotor.class, "elevator");

        // Motor fren davranışı

        elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Motor fren davranışı
        elevator.setDirection(DcMotor.Direction.FORWARD); // Motor yönü (gerekiyorsa değiştir)
    }

    public void moveDownElevator(int pos) {


        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        elevator.setTargetPosition(pos);
        elevator.setPower(1);
    }

    public void moveUpElevator(int pos) {


        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        elevator.setTargetPosition(pos);
        elevator.setPower(-1);
    }

    public void tirman(){
        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        elevator.setTargetPosition(0);
        elevator.setPower(1);
    }

}
