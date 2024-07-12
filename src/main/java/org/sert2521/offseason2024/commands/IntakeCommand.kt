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
        Intake.setSpeed(MotorSpeeds.INTAKE_SPEED)
    }

    override fun isFinished():Boolean {
        return false
    }

    override fun end(interrupted: Boolean) {
        Intake.stop()
    }
}
