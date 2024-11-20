package org.sert2521.offseason2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sert2521.offseason2024.ElectronicIDs.intakeone
import org.sert2521.offseason2024.ElectronicIDs.intaketwo

object Intake : SubsystemBase() {
    private val motorone = CANSparkMax(intakeone, CANSparkLowLevel.MotorType.kBrushless)
    private val motortwo = CANSparkMax(intaketwo, CANSparkLowLevel.MotorType.kBrushless)

    init{
        motorone.idleMode= CANSparkBase.IdleMode.kBrake
        motortwo.idleMode= CANSparkBase.IdleMode.kBrake
        motorone.setSmartCurrentLimit(40)
        motortwo.setSmartCurrentLimit(30)
        motorone.inverted=false
        motortwo.inverted=false
    }

    fun setMotor(speed:Double){
        motorone.set(speed)
        motortwo.set(speed)
    }

    fun stop(){
        motorone.stopMotor()
        motortwo.stopMotor()
    }
}