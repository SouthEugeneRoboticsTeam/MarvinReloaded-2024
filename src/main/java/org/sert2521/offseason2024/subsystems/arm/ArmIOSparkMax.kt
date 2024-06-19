package org.sert2521.offseason2024.subsystems.arm

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.math.util.Units
import edu.wpi.first.wpilibj.DutyCycleEncoder
import org.sert2521.offseason2024.ElecIDs
import org.sert2521.offseason2024.PhysicalConsts
import kotlin.math.PI

class ArmIOSparkMax(id:Int, currentLimit:Int, inverted:Boolean, brakingMode: CANSparkBase.IdleMode, private val gearReduction:Double):ArmIO {

    private val leftMotor = CANSparkMax(id, CANSparkLowLevel.MotorType.kBrushless)
    private val leftEncoder = leftMotor.encoder

    private val rightMotor = CANSparkMax(id, CANSparkLowLevel.MotorType.kBrushless)
    private val rightEncoder = rightMotor.encoder

    private val encoder = DutyCycleEncoder(ElecIDs.ARM_ENCODER_ID)
    private var encoderRadians = 0.0

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

    override fun getRadians():Double {
        encoderRadians = (encoder.absolutePosition + PhysicalConsts.ARM_ENCODER_OFFSET) * 2 * PI
        return encoderRadians
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