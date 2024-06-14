package org.sert2521.offseason2024.subsystems.arm

import org.littletonrobotics.junction.LogTable
import org.littletonrobotics.junction.inputs.LoggableInputs

interface ArmIO {
    class ArmIOInputs:LoggableInputs{
        //Left motor
        var positionRadiansL = 0.0
        var velocityRadPerSecL = 0.0
        var appliedVoltageL = 0.0
        var supplyCurrentAmpsL = 0.0
        var tempCelsiusL = 0.0

        //Right motor
        var positionRadiansR = 0.0
        var velocityRadPerSecR = 0.0
        var appliedVoltageR = 0.0
        var supplyCurrentAmpsR = 0.0
        var tempCelsiusR = 0.0

        override fun toLog(table: LogTable){
            //Left motor
            table.put("positionRadiansL", positionRadiansL)
            table.put("velocityRadPerSecL", velocityRadPerSecL)
            table.put("appliedVoltageL", appliedVoltageL)
            table.put("supplyCurrentAmpsL", supplyCurrentAmpsL)
            table.put("tempCelsiusL", tempCelsiusL)

            //Right motor
            table.put("positionRadiansR", positionRadiansR)
            table.put("velocityRadPerSecR", velocityRadPerSecR)
            table.put("appliedVoltageR", appliedVoltageR)
            table.put("supplyCurrentAmpsR", supplyCurrentAmpsR)
            table.put("tempCelSiusR", tempCelsiusR)
        }

        override fun fromLog(table: LogTable) {
            //Left motor
            positionRadiansL = table.get("positionRadiansL", positionRadiansL)
            velocityRadPerSecL = table.get("velocityRadPerSecL", velocityRadPerSecL)
            appliedVoltageL = table.get("appliedVoltageL", appliedVoltageL)
            supplyCurrentAmpsL = table.get("supplyCurrentAmpsL", supplyCurrentAmpsL)
            tempCelsiusL = table.get("tempCelsiusL", tempCelsiusL)

            //Right motor
            positionRadiansR = table.get("positionRadiansLR", positionRadiansR)
            velocityRadPerSecR = table.get("velocityRadPerSecR", velocityRadPerSecR)
            appliedVoltageR = table.get("appliedVoltageR", appliedVoltageR)
            supplyCurrentAmpsR = table.get("supplyCurrentAmpsR", supplyCurrentAmpsR)
            tempCelsiusR = table.get("tempCelsiusR", tempCelsiusR)
        }
    }

    fun updateInputs(inputs: ArmIOInputs) {}

    fun getRadians() {}
    fun setVoltage(volts:Double) {}
    fun stop() {}
}