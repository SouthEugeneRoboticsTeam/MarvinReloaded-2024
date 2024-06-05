package org.sert2521.offseason2024.utils

import edu.wpi.first.util.struct.Struct
import org.littletonrobotics.junction.LogTable
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KType

class AutoLoggableInput {
    var doubleLogInput:KMutableProperty0<Double>? = null
    var intLogInput:KMutableProperty0<Int>? = null
    var stringLogInput:KMutableProperty0<String>? = null
    var enumLogInput:KMutableProperty0<Enum<*>>? = null
    var boolLogInput:KMutableProperty0<Boolean>? =  null
    var booleanArrayLogInput:KMutableProperty0<BooleanArray>? = null
    var intArrayLogInput:KMutableProperty0<IntArray>? = null
    var doubleArrayLogInput:KMutableProperty0<DoubleArray>? = null
    var strArrayLogInput:KMutableProperty0<Array<out String>>? = null
    var structLogInput:KMutableProperty0<Struct<*>>? = null
    var type: KType? = null
    var input:KMutableProperty0<*>? = null


    constructor(logInput:KMutableProperty0<Double>){
        doubleLogInput=logInput
        type=logInput.returnType
        input=logInput
    }

    constructor(logInput:KMutableProperty0<Int>){
        intLogInput=logInput
        type=logInput.returnType
        input=logInput
    }

    constructor(logInput:KMutableProperty0<String>){
        stringLogInput=logInput
        type=logInput.returnType
        input=logInput
    }

    constructor(logInput:KMutableProperty0<Enum<*>>){
        enumLogInput=logInput
        type=logInput.returnType
        input=logInput
    }

    constructor(logInput:KMutableProperty0<Boolean>){
        boolLogInput=logInput
        type=logInput.returnType
        input=logInput
    }

    constructor(logInput:KMutableProperty0<BooleanArray>){
        booleanArrayLogInput=logInput
        type=logInput.returnType
        input=logInput
    }

    constructor(logInput:KMutableProperty0<IntArray>){
        intArrayLogInput=logInput
        type=logInput.returnType
        input=logInput
    }

    constructor(logInput:KMutableProperty0<DoubleArray>){
        doubleArrayLogInput=logInput
        type=logInput.returnType
        input=logInput
    }

    constructor(logInput:KMutableProperty0<Array<out String>>){
        strArrayLogInput=logInput
        type=logInput.returnType
        input=logInput
    }

    constructor(logInput:KMutableProperty0<Struct<*>>){
        structLogInput=logInput
        type=logInput.returnType
        input=logInput
    }

    constructor(logInput:Any){
        type=null
        throw (IllegalArgumentException("Log input can only be of types supported"))

    }
    /*

    fun logAs(type:Double, logInput:LogTable){
        val temp = doubleLogInput
        when (temp){
            null -> null
            else -> logInput.put(temp.name, temp.get())
        }
    }

    fun logAs(type:Int, logInput:LogTable){
        val temp = intLogInput
        when (temp){
            null -> null
            else -> logInput.put(temp.name, temp.get())
        }
    }

    fun logAs(type:String, logInput:LogTable){
        val temp = stringLogInput
        when (temp){
            null -> null
            else -> logInput.put(temp.name, temp.get())
        }
    }

    fun logAs(type:Enum<*>, logInput:LogTable){
        val temp = enumLogInput
        when (temp){
            null -> null
            else -> logInput.put(temp.name, temp.get())
        }
    }

    fun logAs(type:Boolean, logInput:LogTable){
        val temp = boolLogInput
        when (temp){
            null -> null
            else -> logInput.put(temp.name, temp.get())
        }
    }

    fun logAs(type:BooleanArray):BooleanArray?{
        val temp = booleanArrayLogInput
        when (temp){
            null -> null
            else -> logInput.put(temp.name, temp.get())
        }
    }

    fun logAs(type:IntArray):IntArray?{
        val temp = intArrayLogInput
        when (temp){
            null -> null
            else -> logInput.put(temp.name, temp.get())
        }
    }

    fun logAs(type:DoubleArray):DoubleArray?{
        val temp = doubleArrayLogInput
        when (temp){
            null -> null
            else -> logInput.put(temp.name, temp.get())
        }
    }

    fun logAs(type:Array<out String>):Array<out String>?{
        val temp = strArrayLogInput
        when (temp){
            null -> null
            else -> logInput.put(temp.name, temp.get())
        }
    }

    fun logAs(type:Struct<*>):Struct<*>?{
        val temp = structLogInput
        when (temp){
            null -> null
            else -> logInput.put(temp.name, temp.get())
        }
    }

     */

    fun log(logInput:LogTable){
        if (doubleLogInput != null){
            logInput.put(doubleLogInput!!.name, doubleLogInput!!.get())
        } else if (intLogInput != null){
            logInput.put(intLogInput!!.name, intLogInput!!.get())
        } else if (stringLogInput != null){
            logInput.put(stringLogInput!!.name, stringLogInput!!.get())
        //} else if (enumLogInput != null){
            //logInput.put(enumLogInput!!.name, enumLogInput!!.get())
        } else if (boolLogInput != null){
            logInput.put(boolLogInput!!.name, boolLogInput!!.get())
        } else if (booleanArrayLogInput != null){
            logInput.put(booleanArrayLogInput!!.name, booleanArrayLogInput!!.get())
        } else if (intArrayLogInput != null){
            logInput.put(intArrayLogInput!!.name, intArrayLogInput!!.get())
        } else if (doubleArrayLogInput != null){
            logInput.put(doubleArrayLogInput!!.name, doubleArrayLogInput!!.get())
        } else if (strArrayLogInput != null){
            logInput.put(strArrayLogInput!!.name, strArrayLogInput!!.get())
        } else if (structLogInput != null){
            logInput.put(structLogInput!!.name, structLogInput!!.get())
        }
    }




}