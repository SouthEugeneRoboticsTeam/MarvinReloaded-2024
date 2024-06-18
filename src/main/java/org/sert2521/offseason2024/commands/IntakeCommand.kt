package org.sert2521.offseason2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.offseason2024.MotorSpeeds
import org.sert2521.offseason2024.subsystems.intake.Intake

class IntakeCommand: Command() {

    init {
           addRequirements(Intake)
    }

    override fun initialize() {
    }

    override fun execute() {
        Intake.io.setPullerSpeed(MotorSpeeds.INTAKE_PULLER_SPEED)
        Intake.io.setAlignSpeed(MotorSpeeds.INTAKE_ANIGN_SPEED)
    }

    override fun isFinished():Boolean {
        return false
    }
}
