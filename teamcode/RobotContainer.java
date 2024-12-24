package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.commands.CloseClampsCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.ArmUpCommand;
import org.firstinspires.ftc.teamcode.commands.ArmDownCommand;
import org.firstinspires.ftc.teamcode.commands.ElevatorDownCommand;
import org.firstinspires.ftc.teamcode.commands.ElevatorOrta;
import org.firstinspires.ftc.teamcode.commands.ElevatorUpCommand;

import org.firstinspires.ftc.teamcode.commands.IntakeDownCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeUpCommand;
import org.firstinspires.ftc.teamcode.commands.OpenClapmsCommand;
import org.firstinspires.ftc.teamcode.commands.SliderBackCommand;
import org.firstinspires.ftc.teamcode.commands.SliderBackSlow;
import org.firstinspires.ftc.teamcode.commands.SliderFowardCommand;
import org.firstinspires.ftc.teamcode.commands.SliderFowerdSlow;
import org.firstinspires.ftc.teamcode.commands.TakeWhellCommand;
import org.firstinspires.ftc.teamcode.commands.supurge_ac_command;
import org.firstinspires.ftc.teamcode.commands.supurge_kapat_command;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ElevatorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.HookSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SliderSubsystem;

public class RobotContainer {
    private final DriveSubsystem driveSubsystem;
    private final ArmSubsystem armSubsystem;
    private final SliderSubsystem sliderSubsystem;
    private final ElevatorSubsystem elevatorSubsystem;
    private final IntakeSubsystem intakeSubsystem;
    private final HookSubsystem hookSubsystem;


    private final DriveCommand driveCommand;
    private final GamepadEx operatorGamepad;
    private final GamepadEx main;

    public RobotContainer(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2) {
        // Alt sistemleri başlat
        driveSubsystem = new DriveSubsystem(hardwareMap);
        armSubsystem = new ArmSubsystem(hardwareMap);
        sliderSubsystem = new SliderSubsystem(hardwareMap);
        elevatorSubsystem = new ElevatorSubsystem(hardwareMap);
        intakeSubsystem = new IntakeSubsystem(hardwareMap);
        hookSubsystem = new HookSubsystem(hardwareMap);

        operatorGamepad = new GamepadEx(gamepad2);
        main = new GamepadEx(gamepad1);


        // Komutları başlat
        driveCommand = new DriveCommand(driveSubsystem, gamepad1);

        // Varsayılan komutları ayarla
        driveSubsystem.setDefaultCommand(driveCommand);

        // Gamepad girişlerini bağla
        configureBindings();
    }

    public void configureBindings() {


        new GamepadButton(operatorGamepad, GamepadKeys.Button.B)
                .whenHeld(new ArmUpCommand(armSubsystem));

        new GamepadButton(operatorGamepad, GamepadKeys.Button.X)
                .whenHeld(new ArmDownCommand(armSubsystem));

        new GamepadButton(operatorGamepad, GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(new SliderBackCommand((sliderSubsystem))); // Komut slider'ı açar

        new GamepadButton(operatorGamepad, GamepadKeys.Button.LEFT_BUMPER)
                .whenHeld(new SliderFowardCommand(sliderSubsystem));

        new GamepadButton(operatorGamepad, GamepadKeys.Button.Y)
                .whenHeld(new ElevatorUpCommand(elevatorSubsystem));

        new GamepadButton(operatorGamepad, GamepadKeys.Button.A)
                .whenHeld(new ElevatorDownCommand(elevatorSubsystem));



        new GamepadButton(main, GamepadKeys.Button.RIGHT_BUMPER)
                .whenHeld(new OpenClapmsCommand(hookSubsystem));

        new GamepadButton(main, GamepadKeys.Button.LEFT_BUMPER)
                .whenHeld(new CloseClampsCommand(hookSubsystem));

        new GamepadButton(operatorGamepad, GamepadKeys.Button.DPAD_RIGHT)
                .whenHeld(new TakeWhellCommand(intakeSubsystem));

        new GamepadButton(operatorGamepad, GamepadKeys.Button.DPAD_DOWN)
                .whenHeld(new IntakeDownCommand(intakeSubsystem));

        new GamepadButton(operatorGamepad, GamepadKeys.Button.DPAD_UP)
                .whenHeld(new IntakeUpCommand(intakeSubsystem));

        new GamepadButton(main, GamepadKeys.Button.A)
                .whenHeld(new supurge_ac_command(intakeSubsystem));


        new GamepadButton(main, GamepadKeys.Button.Y)
                .whenHeld(new supurge_kapat_command(intakeSubsystem));


        new GamepadButton(operatorGamepad, GamepadKeys.Button.LEFT_STICK_BUTTON)
                .whenHeld(new SliderBackSlow(sliderSubsystem));

        new GamepadButton(operatorGamepad, GamepadKeys.Button.RIGHT_STICK_BUTTON)
                .whenHeld(new SliderFowerdSlow(sliderSubsystem));

        new GamepadButton(main, GamepadKeys.Button.B)
                .whenHeld(new ElevatorOrta(elevatorSubsystem));

    }

    public void run() {
        CommandScheduler.getInstance().run();
    }
}
