package org.sert2521.offseason2024.commands

import edu.wpi.first.math.controller.ArmFeedforward
import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.offseason2024.PIDFFConsts
import org.sert2521.offseason2024.subsystems.Arm

class ResetArm() : Command() {
    private var armAngle = Arm.getRadians()
    private var feedForward = ArmFeedforward(PIDFFConsts.ARM_S, PIDFFConsts.ARM_G, PIDFFConsts.ARM_V, PIDFFConsts.ARM_A)

    private val done = false

    init {
        addRequirements(Arm)
    }

    override fun initialize() {
        armAngle = Arm.getRadians()
    }

    override fun execute() {
        armAngle = Arm.getRadians()
        val feedforwardResult = feedForward.calculate(armAngle, 0.0)
        Arm.setVoltage(feedforwardResult-0.8)
    }

    override fun isFinished(): Boolean {
        return done
    }

    override fun end(interrupted: Boolean) {
        Arm.resetEncoder()
    }
}