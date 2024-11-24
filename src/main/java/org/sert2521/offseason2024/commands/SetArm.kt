package org.sert2521.offseason2024.commands

import edu.wpi.first.math.controller.ArmFeedforward
import edu.wpi.first.math.controller.ProfiledPIDController
import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.offseason2024.ConfigConsts
import org.sert2521.offseason2024.PIDFFConsts
import org.sert2521.offseason2024.PhysicalConsts
import org.sert2521.offseason2024.subsystems.Arm

class SetArm(var goal:Double) : Command() {

    private var feedForward = ArmFeedforward(PIDFFConsts.ARM_S, PIDFFConsts.ARM_G, PIDFFConsts.ARM_V, PIDFFConsts.ARM_A)
    private var pid = ProfiledPIDController(PIDFFConsts.ARM_P, PIDFFConsts.ARM_I, PIDFFConsts.ARM_D, PhysicalConsts.trapConstraints)

    var done = false
    var armAngle = Arm.getRadians()
    var armTarget = 0.0

    init {
        addRequirements(Arm)
    }

    override fun initialize() {
        armAngle = Arm.getRadians()
        armTarget = goal
    }

    override fun execute() {
        done = false
        armAngle = Arm.getRadians()
        val pidResult = pid.calculate(armAngle, goal)
        val ffResult = feedForward.calculate(pid.setpoint.position, pid.setpoint.velocity)
        val resultVoltage = pidResult + ffResult

        Arm.setVoltage(resultVoltage)

        if (armAngle < goal + ConfigConsts.ARM_ANGLE_TOLERANCE && armAngle > goal - ConfigConsts.ARM_ANGLE_TOLERANCE) {
            done = true
        }
    }

    override fun isFinished(done:Boolean): Boolean {
        return done
    }
}