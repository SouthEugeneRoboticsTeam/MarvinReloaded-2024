package org.sert2521.offseason2024.subsystems.arm

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax

class ArmIOSparkMax(id:Int, currentLimit:Int, Inverted:Boolean, brakingMode: CANSparkBase.IdleMode, private val gearReduction:Double):ArmIO {

    private val leftMotor = CANSparkMax(id, CANSparkLowLevel.MotorType.kBrushless)
    private val rightMotor = CANSparkMax(id, CANSparkLowLevel.MotorType.kBrushless)
}