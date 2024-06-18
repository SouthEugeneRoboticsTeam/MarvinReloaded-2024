package org.sert2521.offseason2024.subsystems.arm

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.math.util.Units

class ArmIOSparkMax(id:Int, currentLimit:Int, inverted:Boolean, brakingMode: CANSparkBase.IdleMode, private val gearReduction:Double):ArmIO {

    private val leftMotor = CANSparkMax(id, CANSparkLowLevel.MotorType.kBrushless)
    private val leftEncoder = leftMotor.encoder

    private val rightMotor = CANSparkMax(id, CANSparkLowLevel.MotorType.kBrushless)
    private val rightEncoder = rightMotor.encoder

    private var armAngle:Double = 2.0 //TODO: CHANGE THIS!!!

    init {
        leftMotor.setSmartCurrentLimit(currentLimit)
        leftMotor.idleMode = brakingMode
        leftMotor.inverted = inverted

        rightMotor.setSmartCurrentLimit(currentLimit)
        rightMotor.idleMode = brakingMode
        rightMotor.inverted = inverted
    }

    override fun updateInputs(inputs: ArmIO.ArmIOInputs) {

        //Left Motor
        inputs.appliedVoltageL = leftMotor.appliedOutput * leftMotor.busVoltage
        inputs.positionRadiansL = Units.rotationsToRadians(leftEncoder.position) / gearReduction
        inputs.velocityRadPerSecL =
            Units.rotationsPerMinuteToRadiansPerSecond(leftEncoder.velocity) / gearReduction
        inputs.supplyCurrentAmpsL = leftMotor.outputCurrent
        inputs.tempCelsiusL = leftMotor.motorTemperature

        //Right Motor
        inputs.appliedVoltageR = rightMotor.appliedOutput * rightMotor.busVoltage
        inputs.positionRadiansR = Units.rotationsToRadians(rightEncoder.position) / gearReduction
        inputs.velocityRadPerSecR =
            Units.rotationsPerMinuteToRadiansPerSecond(rightEncoder.velocity) / gearReduction
        inputs.supplyCurrentAmpsR = rightMotor.outputCurrent
        inputs.tempCelsiusR = rightMotor.motorTemperature
    }

    fun getRadians(armAngle:Double): Double {
    //TODO: Do this part (I don't know how to do it)
    //This is temporary
    return 2.0
    }
    override fun setVoltage(volts:Double) {
        leftMotor.setVoltage(volts)
        rightMotor.setVoltage(volts)
    }
    override fun stop() {
        leftMotor.stopMotor()
        rightMotor.stopMotor()
    }
}