package org.sert2521.offseason2024.subsystems.intake

import edu.wpi.first.math.geometry.Pose2d
import edu.wpi.first.math.kinematics.SwerveDriveKinematics
import org.littletonrobotics.junction.AutoLog
import org.littletonrobotics.junction.inputs.LoggableInputs
import org.sert2521.offseason2024.utils.AutoLoggableInput
import org.sert2521.offseason2024.utils.AutoLoggableInputs


interface IntakeIO {


    class IntakeIOInputs {
        var positionRadians = 0.0
        var velocityRadPerSec = 0.0
        var appliedVoltage = 0.0
        var supplyCurrentAmps = 0.0
        var tempCelsius = 0.0

        var inputs = AutoLoggableInputs(::positionRadians, ::velocityRadPerSec, ::appliedVoltage, ::supplyCurrentAmps, ::tempCelsius)
    }

    fun updateInputs(inputs:IntakeIOInputs) {}

    fun setVoltage(volts:Double) {}
    fun stop() {}
}