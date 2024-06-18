package org.sert2521.offseason2024.subsystems.intake

import org.littletonrobotics.junction.LogTable
import org.littletonrobotics.junction.inputs.LoggableInputs


interface IntakeIO {


    class IntakeIOInputs:LoggableInputs{
        var pullerPositionRadians = 0.0
        var pullerVelocityRadPerSec = 0.0
        var pullerAppliedVoltage = 0.0
        var pullerSupplyCurrentAmps = 0.0
        var pullerTempCelsius = 0.0

        var alignPositionRadians = 0.0
        var alignVelocityRadPerSec = 0.0
        var alignAppliedVoltage = 0.0
        var alignSupplyCurrentAmps = 0.0
        var alignTempCelsius = 0.0

        override fun toLog(table: LogTable) {
            table.put("pullerPositionRadians", pullerPositionRadians)
            table.put("pullerVelocityRadPerSec", pullerVelocityRadPerSec)
            table.put("pullerAppliedVoltage", pullerAppliedVoltage)
            table.put("pullerSupplyCurrentAmps", pullerSupplyCurrentAmps)
            table.put("pullerTempCelsius", pullerTempCelsius)

            table.put("alignPositionRadians", alignPositionRadians)
            table.put("alignVelocityRadPerSec", alignVelocityRadPerSec)
            table.put("alignAppliedVoltage", alignAppliedVoltage)
            table.put("alignSupplyCurrentAmps", alignSupplyCurrentAmps)
            table.put("alignTempCelsius", alignTempCelsius)
        }

        override fun fromLog(table: LogTable) {
            pullerPositionRadians = table.get("pullerPositionRadians", pullerPositionRadians)
            pullerVelocityRadPerSec = table.get("pullerVelocityRadPerSec", pullerVelocityRadPerSec)
            pullerAppliedVoltage = table.get("pullerAppliedVoltage", pullerAppliedVoltage)
            pullerSupplyCurrentAmps = table.get("supplyCurrentAmps", pullerSupplyCurrentAmps)
            pullerTempCelsius = table.get("tempCelsius", pullerTempCelsius)

            alignPositionRadians = table.get("alignPositionRadians", alignPositionRadians)
            alignVelocityRadPerSec = table.get("alignVelocityRadPerSec", alignVelocityRadPerSec)
            alignAppliedVoltage = table.get("alignAppliedVoltage", alignAppliedVoltage)
            alignSupplyCurrentAmps = table.get("alignAupplyCurrentAmps", alignSupplyCurrentAmps)
            alignTempCelsius = table.get("alignTempCelsius", alignTempCelsius)
        }
    }



    fun updateInputs(inputs:IntakeIOInputs) {}

    fun setPullerVoltage(volts:Double) {}
    fun setPullerSpeed(speed:Double) {}
    fun setAlignVoltage(volts:Double) {}
    fun setAlignSpeed(speed:Double) {}
    fun stop() {}
}