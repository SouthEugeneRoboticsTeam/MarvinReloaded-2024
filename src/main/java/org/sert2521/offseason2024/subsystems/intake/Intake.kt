package org.sert2521.offseason2024.subsystems.intake

import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.littletonrobotics.junction.Logger
import org.sert2521.offseason2024.ConfigConsts
import org.sert2521.offseason2024.ElecIDs
import org.sert2521.offseason2024.PhysicalConsts


object Intake:SubsystemBase(){
    private val name = "Intake"

    /** The object that interacts with motors */
    val io = IntakeIOSparkMax(ElecIDs.INTAKE_ID, ConfigConsts.INTAKE_CURRENT_LIMIT,
        ConfigConsts.INTAKE_INVERTED, ConfigConsts.INTAKE_IDLE_MODE, PhysicalConsts.INTAKE_GEAR_REDUCTION)
    private val inputs = IntakeIO.IntakeIOInputs()

    override fun periodic() {
        io.updateInputs(inputs)
        Logger.processInputs(name, inputs)
    }



    init {

    }

}