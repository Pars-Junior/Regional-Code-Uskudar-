package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSubsystem extends SubsystemBase {
    private final DcMotor intake;
    private final Servo leftWhell;
    private final Servo rightWhell;
    private final Servo supurge;


    public IntakeSubsystem(HardwareMap hardwareMap) {
         intake = hardwareMap.get(DcMotor.class, "kol1");
         leftWhell = hardwareMap.get(Servo.class, "leftWhell");
         rightWhell = hardwareMap.get(Servo.class, "rightWhell");
        supurge = hardwareMap.get(Servo.class, "supurge");

        intake.setDirection(DcMotor.Direction.FORWARD); // Motor yönü (gerekiyorsa değiştir)
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void intakeDown() {

        intake.setPower(1);

    }

    public void intakeUp() {

        intake.setPower(-1);

    }

    public void supurge_ac (){
        supurge.setPosition(0.8);
    }

    public void supurge_kapat (){
        supurge.setPosition(0);
    }

    public void stopIntake()

    {
        intake.setPower(0);
    }

    public void intakeTake(){
        leftWhell.setPosition(-0.5);
        rightWhell.setPosition(1);

    }

    public void WheelsStop(){
        leftWhell.setDirection(Servo.Direction.FORWARD);
        leftWhell.setDirection(Servo.Direction.FORWARD);
        leftWhell.setPosition(0.5);
        rightWhell.setPosition(-0.5);
    }

}
