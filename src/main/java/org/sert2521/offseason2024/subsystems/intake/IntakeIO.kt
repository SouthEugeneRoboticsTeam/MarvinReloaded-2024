package org.sert2521.offseason2024.subsystems.intake

import org.littletonrobotics.junction.LogTable
import org.littletonrobotics.junction.inputs.LoggableInputs


interface IntakeIO {


    class IntakeIOInputs:LoggableInputs{
        var positionRadians = 0.0
        var velocityRadPerSec = 0.0
        var appliedVoltage = 0.0
        var supplyCurrentAmps = 0.0
        var tempCelsius = 0.0

        override fun toLog(table: LogTable) {
            table.put("positionRadians", positionRadians)
            table.put("velocityRadPerSec", velocityRadPerSec)
            table.put("appliedVoltage", appliedVoltage)
            table.put("supplyCurrentAmps", supplyCurrentAmps)
            table.put("tempCelsius", tempCelsius)
        }

        override fun fromLog(table: LogTable) {
            positionRadians = table.get("positionRadians", positionRadians)
            velocityRadPerSec = table.get("velocityRadPerSec", velocityRadPerSec)
            appliedVoltage = table.get("appliedVoltage", appliedVoltage)
            supplyCurrentAmps = table.get("supplyCurrentAmps", supplyCurrentAmps)
            tempCelsius = table.get("tempCelsius", tempCelsius)
        }
    }



    fun updateInputs(inputs:IntakeIOInputs) {}

    fun setVoltage(volts:Double) {}
    fun stop() {}
}