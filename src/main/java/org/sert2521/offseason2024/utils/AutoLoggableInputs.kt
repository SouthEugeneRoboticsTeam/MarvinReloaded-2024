package org.sert2521.offseason2024.utils

import com.google.gson.internal.Primitives
import com.sun.tools.javac.code.Attribute
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import org.littletonrobotics.junction.LogTable
import org.littletonrobotics.junction.inputs.LoggableInputs
import java.lang.reflect.Type
import java.util.function.BooleanSupplier
import javax.lang.model.type.ArrayType
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KType
import kotlin.reflect.javaType

class AutoLoggableInputs<out T>(vararg val logInputs: KMutableProperty0<@UnsafeVariance T>):LoggableInputs{

    init {

    }


    @OptIn(ExperimentalStdlibApi::class)
    override fun fromLog(table: LogTable?) {
        /*if (table == null){
            return
        }

        for (logValue in logInputs){
            when (logValue.get()){
                String -> table.put(logValue.name, logValue.get().toString())
                Double -> table.put(logValue.name, logValue.get().toDouble())
            }
            if (logValue.get() == String){
                table.put(logValue.name, logValue.get().toString())
            } elif ()

        }

         */
    }

    override fun toLog(table: LogTable?) {
        TODO("Not yet implemented")
    }
}


