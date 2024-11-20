package org.sert2521.offseason2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj.DutyCycleEncoder
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.sert2521.offseason2024.ConfigConsts
import org.sert2521.offseason2024.ElectronicIDs
import org.sert2521.offseason2024.PhysicalConsts
import kotlin.math.PI

object Arm : SubsystemBase() {


    private val motorL = CANSparkMax(ElectronicIDs.ARM_MOTOR_L, CANSparkLowLevel.MotorType.kBrushless)
    private val motorR = CANSparkMax(ElectronicIDs.ARM_MOTOR_R, CANSparkLowLevel.MotorType.kBrushless)

    val encoder = motorL.encoder
    val absEncoder = DutyCycleEncoder(1)
    val motorSpeed = 0.0
    var prevRot = 0.0
    var deltaTime = Timer.getFPGATimestamp()
    var vel = 0.0

    init{
        motorL.setSmartCurrentLimit(ConfigConsts.ARM_MOTOR_CURRENT_LIMIT)
        motorR.setSmartCurrentLimit(ConfigConsts.ARM_MOTOR_CURRENT_LIMIT)

        absEncoder.distancePerRotation = PhysicalConsts.ARM_ENCODER_MULTIPLY
        prevRot = getRadians()

        motorL.idleMode = CANSparkBase.IdleMode.kBrake
        motorR.idleMode = CANSparkBase.IdleMode.kBrake

        motorL.inverted = true
        motorR.inverted = false

        //val holdCommand = InstantCommand({ SetWrist(RuntimeConsts.armSetPoint, false).schedule() })
        //holdCommand.addRequirements(this)
        //defaultCommand = holdCommand
    }

    override fun periodic() {

    }

    fun resetEncoder() {
        absEncoder.reset()
    }

    fun setSpeed(speed: Double) {
        motorL.set(speed)
        motorR.set(speed)
    }

    fun setVoltage(voltage: Double) {
        motorL.setVoltage(voltage)
        motorR.setVoltage(voltage)
    }

    fun getEncoder():Double {
        return absEncoder.distance
    }

    fun getRadians():Double {
        var wristAngle = (absEncoder.distance+ PI /2).mod(2* PI) - PI /2 + PhysicalConsts.ARM_ENCODER_OFFSET

        return wristAngle
    }

    fun getAmps(): Pair<Double, Double> {
        return Pair(motorL.outputCurrent, motorR.outputCurrent)
    }

    fun stop() {
        motorL.stopMotor()
        motorR.stopMotor()
    }

    fun setCurrentLimit(first:Int){
        motorL.setSmartCurrentLimit(first)
        motorR.setSmartCurrentLimit(first)
    }
}