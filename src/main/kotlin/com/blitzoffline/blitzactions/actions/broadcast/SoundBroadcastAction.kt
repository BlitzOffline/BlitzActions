package com.blitzoffline.blitzactions.actions.broadcast

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.parsePAPI
import org.bukkit.Bukkit
import org.bukkit.Sound

class SoundBroadcastAction : Action {
    override val name = "SOUNDBROADCAST"
    override fun run(actionData: ActionData) {
        val target = actionData.target

        Bukkit.getOnlinePlayers().forEach { player ->
            val arguments = if (target != null) actionData.data.parsePAPI(target).split(":") else actionData.data.parsePAPI(player).split(":")

            val sound = Sound.valueOf(arguments[0])
            val volume = arguments[1].toFloat()
            val pitch = arguments[2].toFloat()

            player.playSound(player.location, sound, volume, pitch)
        }
    }
}