package org.sert2521.offseason2024

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import org.sert2521.offseason2024.commands.RunIndexer

object Bindings {
    val driverController = XboxController(0)
    val gunnerController = Joystick(1)

    val indexerButton = JoystickButton(driverController, 3)


    init{
        indexerButton.whileTrue(RunIndexer())
    }
}