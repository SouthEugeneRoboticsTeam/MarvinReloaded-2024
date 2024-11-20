package org.sert2521.offseason2024

import com.revrobotics.CANSparkBase

/*
 * The Constants file provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This file should not be used for any other purpose.
 * All String, Boolean, and numeric (Int, Long, Float, Double) constants should use
 * `const` definitions. Other constant types should use `val` definitions.
 *
 * The constants file MUST be extremely easy for any non-software member to understand
 * and modify any value that could be changed in the length of a competition.
 * This includes things like motor PIDFFs, motor IDs, setpoints, or timings.
 * If you ever have to change a double or other value in a file that is not in constants,
 * that value should have gone in the constants file.
 *
 * Keep in mind that these constants do not include any constants that are related to
 * swerve drive, as that is covered by another file.
 */

/**
 * Physical Constants refers to any physical properties of the robot.
 * This includes setpoints, distances, measurements, gear reductions,
 * or anything else obtainable by the CAD.
 * This does not include things like tuned timings or PID values.
 * This also specifically excludes swerve drive configuration,
 * as that is covered by another constants class/json file (haven't decided yet)
 */
object PhysicalConsts {
}

/**
 * These are the electronic ids of the motor controllers.
 */
object ElectronicIDs {
    val intakeone=-1
    val intaketwo=-2
}

/**
 * All current limits are in amps. Idle mode can be kCoast (Coasting) or kBrake (Braking mode).
 * If the motor is running the wrong direction, then the inverted value for the motor must be changed.
 * All motor names should be agreed upon and understood by electrical members in regular comp.
 */
object ConfigConsts {
}


/**
 * PIDFFConsts is used for any PID/Feedforward constants that are used in subsystems and commands.
 * Remember that when tuning,
 * P: Faster, more overshoot and oscillation  at setpoint
 * I: Please don't use
 * D: Slightly slower, more oscillation before setpoint
 *
 * S: Static gain, adds same voltage at all times
 * V: Velocity gain, add voltage multiplied by target ending velocity
 * G: Gravity gain (only in arms), add voltage based on target arm angle, accounts for gravity
 * A: Acceleration gain (only used sometimes), add voltage based on target acceleration.
 */
object PIDFFConsts{

}







