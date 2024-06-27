package org.sert2521.offseason2024.subsystems.climber

import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.sert2521.offseason2024.ElecIDs

object Climber:SubsystemBase() {
    private val name = "Climber"

    val io = ClimberIOSparkMax()
}