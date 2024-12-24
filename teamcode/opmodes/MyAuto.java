package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name = "3 Sample + Park")
public class MyAuto extends LinearOpMode {

    private DcMotor leftFront, rightFront, leftBack, rightBack, elevator, Slider, ArmMotor , intake ;
    private FtcDashboard dashboard;
    private Servo arm1Servo, arm2Servo, leftWhell, rightWhell;



    private int leftFrontPos = 0;
    private int rightFrontPos = 0;
    private int leftBackPos = 0;
    private int rightBackPos = 0;

    @Override
    public void runOpMode() {
        setupTelemetry();
        initializeHardware();

        TelemetryPacket packet = new TelemetryPacket();


        telemetry.update();
        dashboard.sendTelemetryPacket(packet);

        resetDriveEncoders();





        waitForStart();

        executeAutonomousRoutine();
    }


    public void setupTelemetry() {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.setMsTransmissionInterval(10);
    }


    public void initializeHardware() {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        intake = hardwareMap.get(DcMotor.class, "kol1");
        leftWhell = hardwareMap.get(Servo.class, "leftWhell");
        rightWhell = hardwareMap.get(Servo.class, "rightWhell");

        elevator = hardwareMap.get(DcMotor.class, "elevator");
        Slider = hardwareMap.get(DcMotor.class, "Slider");
        ArmMotor = hardwareMap.get(DcMotor.class, "ArmMotor");

        arm1Servo = hardwareMap.get(Servo.class, "arm1servo");
        arm2Servo = hardwareMap.get(Servo.class, "arm2servo");






        configureMotorDirections();
        configureMotorBehavior();

        dashboard = FtcDashboard.getInstance();
    }

    public void configureMotorDirections() {
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        arm2Servo.setDirection(Servo.Direction.REVERSE);
    }

    public void configureMotorBehavior() {
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Slider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void moveWheels(){
        leftWhell.setPosition(-0.5);
        rightWhell.setPosition(1);
    }

    public void stopWheels(){
        leftWhell.setDirection(Servo.Direction.FORWARD);
        leftWhell.setDirection(Servo.Direction.FORWARD);
        leftWhell.setPosition(1);
        rightWhell.setPosition(-0.5);
    }

    public void resetDriveEncoders() {
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void executeAutonomousRoutine() {



        /// Step 1: Drop First Sample

        drive(400,-400,-400,400,0.7);
        drive(200,200,200,200,0.7);
        sleep(200);
        ElevatorBasket();
        sleep(1700);
        ArmBasket();
        sleep(1000);
        kancaAc();
        sleep(500);
        ArmZero();
        sleep(400);
        ElevatorZero();




        ///////////////////////////////////////////////////////

        /// Step 2: Take The Second Sample To Spike Band

        intakeAlmaMode();
        sleep(300);
        drive(230,230,-230,-230,0.7);
        sleep(500);
        drive(-730,-730,-730,-730,0.25);
        sleep(1700);
        intakeYukariMode();
        sleep(1100);
        Slider.setPower(1);
        sleep(200);

        /////////////////////////////////////////////////////////

        /// Step 3: Drop Second Sample

        kancaKapat();
        sleep(500);
        drive(670,670,670,670,0.6);
        sleep(1200);
        drive(-210,-210,210,210,0.7);

        ElevatorBasket();
        sleep(1700);
        ArmBasket();
        sleep(1200);
        kancaAc();
        sleep(500);
        ArmZero();
        sleep(600);
        ElevatorZero();


        /////////////////////////////////////////////////////////


        /// Step 4: Take The Third Sample To Spike Band

        intakeAlmaMode();
        sleep(300);
        drive(335,335,-335,-335,0.7);
        sleep(500);
        drive(-880,-880,-880,-880,0.4);
        sleep(1600);

        intakeYukariMode();
        sleep(1300);
        Slider.setPower(1);
        sleep(200);

        ///////////////////////////////////

        /// Step 5 : Drop Third Sample

        kancaKapat();

        sleep(200);
        drive(765,765,765,765,0.5);
        sleep(1000);
        drive(-160,-160,160,160,0.7);
        sleep(500);

        ElevatorBasket();
        sleep(1700);
        ArmBasket();
        sleep(1000);
        kancaAc();
        sleep(500);
        ArmZero();
        sleep(600);
        ElevatorZero();

        ///////////////////////////////////

        /// Step 6: Go To Parking Area

        drive(-300,300,300,-300,0.7);
        drive(-1900,-1900,-1900,-1900,0.8);
        sleep(2000);
        drive(800,800,-800,-800,0.7);
        sleep(1500);
        drive(600,600,600,600,0.3);
        TemasMode();
        sleep(1000);

        //////////////////////////////////////


    }

    public void drive(int leftFrontTarget, int leftBackTarget, int rightFrontTarget, int rightBackTarget, double speed) {
        leftFrontPos += leftFrontTarget;
        leftBackPos += leftBackTarget;
        rightFrontPos += rightFrontTarget;
        rightBackPos += rightBackTarget;

        leftFront.setTargetPosition(leftFrontPos);
        leftBack.setTargetPosition(leftBackPos);
        rightFront.setTargetPosition(rightFrontPos);
        rightBack.setTargetPosition(rightBackPos);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFront.setPower(speed);
        leftBack.setPower(speed);
        rightFront.setPower(speed);
        rightBack.setPower(speed);
    }


    public void intakeAlmaMode(){
        intake.setTargetPosition(100);
        intake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        intake.setPower(0.8);
        moveWheels();
    }



    public void intakeYukariMode(){
        intake.setTargetPosition(0);
        intake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        intake.setPower(0.8);
        stopWheels();
    }

    public void kancaAc(){

        arm1Servo.setPosition(0);
        arm2Servo.setPosition(0);
    }

    public void kancaKapat(){

        arm1Servo.setPosition(0.5);
        arm2Servo.setPosition(0.5);
    }

    public void ElevatorBasket(){
        elevator.setTargetPosition(-4500);
        elevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevator.setPower(1);
    }

    public void ElevatorZero(){
        elevator.setTargetPosition(0);
        elevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevator.setPower(1);
    }

    public void ArmBasket(){
        ArmMotor.setTargetPosition(190);
        ArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ArmMotor.setPower(0.6);
    }

    public void ArmZero(){
        ArmMotor.setTargetPosition(-20);
        ArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ArmMotor.setPower(1);
    }

    public void TemasMode(){
        ArmMotor.setTargetPosition(250);
        ArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ArmMotor.setPower(1);

    }



}