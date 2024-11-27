package org.sert2521.offseason2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.offseason2024.subsystems.Indexer

class RunIndexer : Command() {
    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(Indexer)
    }

    override fun initialize() {
        Indexer.setMotor(0.5)
    }

    override fun execute() {

    }

    override fun isFinished(): Boolean {
        return Indexer.getBeamBreak()
    }

    override fun end(interrupted: Boolean) {
        Indexer.stopMotor()
    }
}
