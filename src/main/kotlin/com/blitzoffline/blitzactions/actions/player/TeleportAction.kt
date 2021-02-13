package com.blitzoffline.blitzactions.actions.player

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.parsePAPI
import org.bukkit.Bukkit
import org.bukkit.Location

class TeleportAction : Action {
    override val name = "TELEPORT"

    override fun run(actionData: ActionData) {
        val player = actionData.player ?: return
        val target = actionData.target
        val arguments = if (target!= null) actionData.data.parsePAPI(target).split(";") else actionData.data.parsePAPI(player).split(";")

        val world = Bukkit.getWorld(arguments[0])
        val x = arguments[1].toDouble()
        val y = arguments[2].toDouble()
        val z = arguments[3].toDouble()
        val yaw = arguments[4].toFloat()
        val pitch = arguments[5].toFloat()

        val location = Location(world, x, y, z, yaw, pitch)
        player.teleportAsync(location)
    }
}