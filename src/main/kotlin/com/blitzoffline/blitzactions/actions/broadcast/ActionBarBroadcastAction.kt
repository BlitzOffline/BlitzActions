package com.blitzoffline.blitzactions.actions.broadcast

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.parsePAPI
import org.bukkit.Bukkit

class ActionBarBroadcastAction : Action {
    override val name = "ACTIONBARBROADCAST"

    override fun run(actionData: ActionData) {
        val players = Bukkit.getOnlinePlayers()
        val target = actionData.target
        val message = actionData.data

        players.forEach { player ->
            if (target != null) player.sendActionBar(message.parsePAPI(target))
            else player.sendActionBar(message.parsePAPI(player))
        }
    }
}