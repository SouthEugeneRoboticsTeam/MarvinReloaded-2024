package org.sert2521.offseason2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.sert2521.offseason2024.ElectronicIDs


class Intake:SubsystemBase() {
    private val intakeMotor = CANSparkMax(ElectronicIDs.INTAKE_MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless)
    private val encoder = intakeMotor.encoder

    private val alignmentMotor = CANSparkMax(ElectronicIDs.INTAKE_MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless)
    private val encoder2 = intakeMotor.encoder

    init {
        intakeMotor.idleMode = CANSparkBase.IdleMode.kBrake
        intakeMotor.setSmartCurrentLimit(30)
        intakeMotor.inverted = true

        alignmentMotor.idleMode = CANSparkBase.IdleMode.kBrake
        alignmentMotor.setSmartCurrentLimit(30)
        alignmentMotor.inverted = true
    }

    fun setMotor(speed:Double){
        intakeMotor.set(speed)
        alignmentMotor.set(speed)
    }

    fun stopMotor(){
        intakeMotor.stopMotor()
        alignmentMotor.stopMotor()
    }
}