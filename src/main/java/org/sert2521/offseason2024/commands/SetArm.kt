package org.sert2521.offseason2024.commands

import edu.wpi.first.math.controller.ArmFeedforward
import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.math.controller.ProfiledPIDController
import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.offseason2024.PIDFFConsts
import org.sert2521.offseason2024.PhysicalConsts
import org.sert2521.offseason2024.RuntimeConsts
import org.sert2521.offseason2024.subsystems.Arm
import kotlin.math.PI


class SetArm(private val goal:Double, private val ends:Boolean) : Command() {

    private var armAngle = Arm.getRadians()
    private var feedForward = ArmFeedforward(PIDFFConsts.ARM_S, PIDFFConsts.ARM_G, PIDFFConsts.ARM_V, PIDFFConsts.ARM_A)
    private var pid = ProfiledPIDController(PIDFFConsts.ARM_P, PIDFFConsts.ARM_I, PIDFFConsts.ARM_D, PhysicalConsts.trapConstraints)
    private var notProfiled = PIDController(PIDFFConsts.ARM_P, PIDFFConsts.ARM_I, PIDFFConsts.ARM_D)

    private var done = false

    init{
        addRequirements(Arm)
    }

    override fun initialize() {
        armAngle = Arm.getRadians()
        RuntimeConsts.armSetPoint = goal
    }

    override fun execute() {
        done = false
        armAngle = Arm.getRadians()
        val pidResult:Double = pid.calculate(armAngle+2* PI, goal+2* PI)
        val feedforwardResult = feedForward.calculate(armAngle+2* PI, goal+2* PI)

        Arm.setVoltage(feedforwardResult + pidResult)
        if (ends && Arm.getRadians()>goal-PhysicalConsts.ARM_ANGLE_TOLERANCE && Arm.getRadians()<goal+PhysicalConsts.ARM_ANGLE_TOLERANCE){
            done=true
        }

    }

    override fun isFinished(): Boolean {
        return done
    }

    override fun end(interrupted: Boolean) {
        if (interrupted) RuntimeConsts.armSetPoint
    }
}