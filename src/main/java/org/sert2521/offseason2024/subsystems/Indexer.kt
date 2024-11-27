package org.sert2521.offseason2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sert2521.offseason2024.ElectronicIDs.BEAMBREAK_ID
import org.sert2521.offseason2024.ElectronicIDs.INDEXER_MOTOR

object Indexer : SubsystemBase() {
    private val indexerMotor = CANSparkMax(INDEXER_MOTOR, CANSparkLowLevel.MotorType.kBrushless)
    private val encoder = indexerMotor.encoder
    private val beamBreak = DigitalInput(BEAMBREAK_ID)

    init {
        indexerMotor.idleMode = CANSparkBase.IdleMode.kBrake
        indexerMotor.setSmartCurrentLimit(30)
        indexerMotor.inverted = false
    }

    fun setMotor(speed:Double){
        indexerMotor.set(speed)
    }

    fun stopMotor(){
        indexerMotor.stopMotor()
    }

    fun getBeamBreak():Boolean{
        return !beamBreak.get()
    }


}