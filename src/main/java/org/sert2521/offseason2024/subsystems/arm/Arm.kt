package org.sert2521.offseason2024.subsystems.arm

import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.littletonrobotics.junction.Logger
import org.sert2521.offseason2024.ConfigConsts
import org.sert2521.offseason2024.ElecIDs
import org.sert2521.offseason2024.PhysicalConsts

object Arm: SubsystemBase() {
    private val name = "Arm"

    val io = ArmIOSparkMax(ElecIDs.ARM_LEFT_ID, ConfigConsts.ARM_CURRENT_LIMIT, ConfigConsts.ARM_LEFT_INVERTED, ConfigConsts.ARM_IDLE_MODE, PhysicalConsts.ARM_GEAR_REDUCTION)
    private val inputs = ArmIO.ArmIOInputs()

    override fun periodic(){
        io.updateInputs(inputs)
        Logger.processInputs(name, inputs)
    }

    init{

    }
}