package com.blitzoffline.blitzactions.actions.broadcast

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.parseJson
import com.blitzoffline.blitzactions.util.parsePAPI
import org.bukkit.Bukkit

class JsonBroadcastAction : Action {
    override val name = "JSONBROADCAST"

    override fun run(actionData: ActionData) {
        val players = Bukkit.getOnlinePlayers()
        val target = actionData.target
        val message = actionData.data

        players.forEach { player ->
            if (target != null) message.parsePAPI(target).parseJson().sendMessage(player)
            else message.parsePAPI(player).parseJson().sendMessage(player)
        }
    }
}