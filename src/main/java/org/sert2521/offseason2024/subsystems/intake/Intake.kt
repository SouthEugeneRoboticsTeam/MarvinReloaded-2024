package org.sert2521.offseason2024.subsystems.intake

import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.littletonrobotics.junction.Logger
import org.sert2521.offseason2024.ConfigConsts
import org.sert2521.offseason2024.ElecIDs
import org.sert2521.offseason2024.PhysicalConsts


object Intake:SubsystemBase(){
    private val name = "Intake"

    /** The object that interacts with motors */
    private val io = IntakeIOSparkMax(ElecIDs.PULLER_ID, ElecIDs.ALIGN_ID, ConfigConsts.INTAKE_CURRENT_LIMIT,
        ConfigConsts.INTAKE_INVERTED, ConfigConsts.INTAKE_IDLE_MODE, PhysicalConsts.INTAKE_GEAR_REDUCTION)
    private val inputs = IntakeIO.IntakeIOInputs()

    override fun periodic() {
        io.updateInputs(inputs)
        Logger.processInputs(name, inputs)
    }

    fun setSpeed(speed:Double){
        io.setAlignSpeed(speed)
        io.setPullerSpeed(speed)
    }

    fun setVoltage(volts:Double){
        io.setPullerVoltage(volts)
        io.setAlignVoltage(volts)
    }

    fun stop(){
        io.stop()
    }

}