package org.sert2521.offseason2024.commands

import edu.wpi.first.math.controller.ArmFeedforward
import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.offseason2024.PIDFFConsts
import org.sert2521.offseason2024.subsystems.arm.Arm
import org.sert2521.offseason2024.subsystems.arm.ArmIO
import org.sert2521.offseason2024.subsystems.arm.ArmIOSparkMax

class SetArm (private val goal:Double, private val ends:Boolean = true) : Command() {
    private var armAngle = 0.0
    private val feedForward = ArmFeedforward(PIDFFConsts.ARM_S, PIDFFConsts.ARM_G, PIDFFConsts.ARM_G, PIDFFConsts.ARM_A)
    private val pid = PIDController(PIDFFConsts.ARM_P, PIDFFConsts.ARM_I, PIDFFConsts.ARM_D)

    private var pidOutput = 0.0
    private var feedForwardOutput = 0.0

    private var done = false

    init {
        addRequirements(Arm)
    }

    override fun execute() {
        armAngle = Arm.io.getRadians()
        pidOutput = pid.calculate(armAngle, goal)
        feedForwardOutput = feedForward.calculate(armAngle, pid.setpoint) //This is probably wrong
    }
}