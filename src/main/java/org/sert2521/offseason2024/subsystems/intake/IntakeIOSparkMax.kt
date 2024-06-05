package org.sert2521.offseason2024.subsystems.intake

import com.revrobotics.CANSparkBase.IdleMode
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import com.revrobotics.RelativeEncoder
import edu.wpi.first.math.util.Units

class IntakeIOSparkMax(id:Int, currentLimit:Int, inverted:Boolean,
    brakingMode:IdleMode, gearReduction:Double):IntakeIO{

    private val motor: CANSparkMax
    private val encoder: RelativeEncoder

    private val gearReduction: Double
    init {
        motor = CANSparkMax(id, CANSparkLowLevel.MotorType.kBrushless)

        this.encoder = motor.encoder
        this.gearReduction = gearReduction

        motor.setSmartCurrentLimit(currentLimit)
        motor.idleMode = brakingMode
        motor.inverted = inverted
    }

    override fun updateInputs(inputs: IntakeIO.IntakeIOInputs) {
        inputs.appliedVoltage = motor.appliedOutput * motor.busVoltage
        inputs.positionRadians = Units.rotationsToRadians(encoder.position) / gearReduction
        inputs.velocityRadPerSec =
            Units.rotationsPerMinuteToRadiansPerSecond(encoder.velocity) / gearReduction
        inputs.supplyCurrentAmps = motor.outputCurrent
        inputs.tempCelsius = motor.motorTemperature
    }

    override fun setVoltage(volts: Double) {
        motor.setVoltage(volts)
    }

    override fun stop(){
        motor.stopMotor()
    }
}