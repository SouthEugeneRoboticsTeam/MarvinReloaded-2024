package org.sert2521.offseason2024.utils

import org.littletonrobotics.junction.LogTable
import org.littletonrobotics.junction.inputs.LoggableInputs

interface AutoLoggableInputs:LoggableInputs{


    override fun fromLog(table: LogTable) {
        val a = ""
        for (field in this.javaClass.declaredFields){
            if (field.type == Integer.TYPE){

                //table.put("AAA", field.get(null))
            }
        }
    }

    override fun toLog(table: LogTable) {
        TODO("Not yet implemented")
    }
}


