package org.sert2521.offseason2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.math.filter.Debouncer
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sert2521.offseason2024.ElectronicIDs
import org.sert2521.offseason2024.PhysicalConsts

object Flywheels : SubsystemBase() {
    val flywheelMotorOne =  CANSparkMax(ElectronicIDs.FLYWHEEL_MOTOR_ONE_ID, CANSparkLowLevel.MotorType.kBrushless)
    val flywheelMotorTwo =  CANSparkMax(ElectronicIDs.FLYWHEEL_MOTOR_TWO_ID, CANSparkLowLevel.MotorType.kBrushless)
    init {
        flywheelMotorOne.encoder.positionConversionFactor = PhysicalConsts.FLYWHEEL_GEAR_RATIO
        flywheelMotorOne.encoder.velocityConversionFactor = PhysicalConsts.FLYWHEEL_GEAR_RATIO
        flywheelMotorOne.idleMode = CANSparkBase.IdleMode.kCoast
        flywheelMotorOne.inverted = false
        flywheelMotorTwo.encoder.positionConversionFactor = PhysicalConsts.FLYWHEEL_GEAR_RATIO
        flywheelMotorTwo.encoder.velocityConversionFactor = PhysicalConsts.FLYWHEEL_GEAR_RATIO
        flywheelMotorTwo.idleMode = CANSparkBase.IdleMode.kCoast
        flywheelMotorTwo.inverted = false
        flywheelMotorOne.setSmartCurrentLimit(40)
        flywheelMotorTwo.setSmartCurrentLimit(40)
    }

    fun setVoltages(voltage: Pair<Double, Double>) {
        flywheelMotorOne.setVoltage(voltage.first)
        flywheelMotorTwo.setVoltage(voltage.second)
    }

    fun setSpeed(speed: Pair<Double, Double>) {
        flywheelMotorOne.set(speed.first)
        flywheelMotorTwo.set(speed.second)
    }

    fun getVelocity(): Pair<Double, Double>{
        return Pair(flywheelMotorOne.encoder.velocity, flywheelMotorTwo.encoder.velocity)
    }
}