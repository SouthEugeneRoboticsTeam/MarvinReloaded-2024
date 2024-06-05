package org.sert2521.offseason2024.subsystems.intake

import org.littletonrobotics.junction.AutoLog

interface IntakeIO {

    @AutoLog
    abstract class IntakeIOInputs{
        var positionRadians = 0.0
        var velocityRadPerSec = 0.0
        var appliedVoltage = 0.0
        var supplyCurrentAmps = 0.0
        var tempCelsius = 0.0
    }

    fun updateInputs(inputs:IntakeIOInputs) {}

    fun setVoltage(volts:Double) {}
    fun stop() {}
}