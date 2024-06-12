package org.sert2521.offseason2024.subsystems.intake

import com.revrobotics.CANSparkBase.IdleMode
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.math.util.Units

class IntakeIOSparkMax(id:Int, currentLimit:Int, inverted:Boolean,
                       brakingMode:IdleMode, private val gearReduction: Double):IntakeIO{

    private val pullerMotor = CANSparkMax(id, CANSparkLowLevel.MotorType.kBrushless)
    private val alignMotor = CANSparkMax(id, CANSparkLowLevel.MotorType.kBrushless)

    private val pullerEncoder = pullerMotor.encoder
    private val alignEncoder = pullerMotor.encoder

    init {
        pullerMotor.setSmartCurrentLimit(currentLimit)
        pullerMotor.idleMode = brakingMode
        pullerMotor.inverted = inverted
    }


    /** This sets the logged variables to the correct values */
    override fun updateInputs(inputs: IntakeIO.IntakeIOInputs) {
        inputs.appliedVoltage = pullerMotor.appliedOutput * pullerMotor.busVoltage
        inputs.positionRadians = Units.rotationsToRadians(pullerEncoder.position) / gearReduction
        inputs.velocityRadPerSec =
            Units.rotationsPerMinuteToRadiansPerSecond(pullerEncoder.velocity) / gearReduction
        inputs.supplyCurrentAmps = pullerMotor.outputCurrent
        inputs.tempCelsius = pullerMotor.motorTemperature

        inputs.appliedVoltage = alignMotor.appliedOutput * alignMotor.busVoltage
        inputs.positionRadians = Units.rotationsToRadians(alignEncoder.position) / gearReduction
        inputs.velocityRadPerSec =
            Units.rotationsPerMinuteToRadiansPerSecond(alignEncoder.velocity) / gearReduction
        inputs.supplyCurrentAmps = alignMotor.outputCurrent
        inputs.tempCelsius = alignMotor.motorTemperature
    }

    override fun setPullerVoltage(volts: Double) {
        pullerMotor.setVoltage(volts)
    }
    override fun setPullerSpeed(speed:Double){
        pullerMotor.set(speed)
    }

    override fun setAlignVoltage(volts: Double) {
        alignMotor.setVoltage(volts)
    }
    override fun setAlignSpeed(speed:Double){
        alignMotor.set(speed)
    }

    override fun stop(){
        pullerMotor.stopMotor()
    }
}