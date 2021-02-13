package com.blitzoffline.blitzactions.actions.player

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.parsePAPI
import org.bukkit.Sound

class SoundAction : Action {
    override val name: String = "SOUND"

    override fun run(actionData: ActionData) {
        val player = actionData.player ?: return
        val target = actionData.target
        val arguments = if (target != null) actionData.data.parsePAPI(target).split(";") else actionData.data.parsePAPI(player).split(";")

        val sound = Sound.valueOf(arguments[0])
        val volume = arguments[1].toFloat()
        val pitch = arguments[2].toFloat()

        player.playSound(player.location, sound, volume, pitch)
    }
}