package org.sert2521.offseason2024

import com.revrobotics.CANSparkBase

/*
 * The Constants file provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This file should not be used for any other purpose.
 * All String, Boolean, and numeric (Int, Long, Float, Double) constants should use
 * `const` definitions. Other constant types should use `val` definitions.
 */
object PhysicalConsts {
    const val INTAKE_GEAR_REDUCTION = 1.0
}

object ElecIDs {
    const val INTAKE_ID = 1
    const val INTAKE_INVERTED = false
}

object ConfigConsts {
    const val INTAKE_CURRENT_LIMIT = 30
    val INTAKE_IDLE_MODE = CANSparkBase.IdleMode.kCoast
}



