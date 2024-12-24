package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name = "2 Clips + Park")
public class MyAuto2 extends LinearOpMode {

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

    public void tukurWheels(){
        leftWhell.setPosition(0.5);
        rightWhell.setPosition(-1);
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



        /// Step 1: Attach The First Clip


        drive(600,600,600,600, 0.6);
        drive(590,590,590,590, 0.3);

        sleep(1200);
        ClipsModu();
        sleep(1000);
        kancaAc();
        drive(-920,-920,-920,-920, 0.4);
        ArmZero();
        sleep(1500);


        //////////////////////////////

        /// Step 2: Run To Second Clip
        drive(1550,-1550,-1550,1550, 0.7);
        Slider.setPower(0.6);
        sleep(2000);
        drive(-300,-300,-300,-300,0.5);
        sleep(700);

        //////////////////////////////

        /// Step 3: Take The Second Clip

        intakeAlmaMode();
        sleep(1500);
        Slider.setPower(0.6);

        kancaKapat();
        intakeYukariMode();

        /////////////////////////////////

        /// Step 4: Run To Bar
        sleep(400);
        drive(150,150,150,150,0.8);
        sleep(500);

        drive(-1550,1550,1550,-1550, 0.7);

        sleep(2200);
        drive(-130,-130,-130,-130, 0.7);
        sleep(200);
        drive(400,400,400,400, 0.6);

        drive(350,350,350,350, 0.5);
        sleep(500);


        //////////////////////////////////

        /// Step 5: Attach The Second Clip
        intakeYerMode();
        ClipsModu3();
        sleep(1200);
        drive(350,350,350,350, 0.5);
        sleep(600);
        ArmZero();
        sleep(800);
        kancaAc();
        sleep(500);


        //////////////////////////////

        /// Step 6: Run To Parking Area
        intakeYukariMode();
        sleep(600);
        drive(-900,-900,-900,-900,0.6);
        sleep(1000);

        drive(1850,-1850,-1850,1850, 0.7);
        Slider.setPower(0.6);
        sleep(2000);


        /////////////////////////////////


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

    public void intakeYerMode(){
        intake.setTargetPosition(100);
        intake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        intake.setPower(0.8);
        tukurWheels();

    }

    public void kancaAc(){

        arm1Servo.setPosition(0);
        arm2Servo.setPosition(0);
    }

    public void kancaKapat(){

        arm1Servo.setPosition(0.5);
        arm2Servo.setPosition(0.5);
    }

    public void ClipsModu(){
        ArmMotor.setTargetPosition(350);
        ArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ArmMotor.setPower(1);
    }

    public void ClipsModu3(){
        ArmMotor.setTargetPosition(225);
        ArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ArmMotor.setPower(1);
    }

    public void ClipsModu3Kapa(){
        ArmMotor.setTargetPosition(-120);
        ArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ArmMotor.setPower(1);
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