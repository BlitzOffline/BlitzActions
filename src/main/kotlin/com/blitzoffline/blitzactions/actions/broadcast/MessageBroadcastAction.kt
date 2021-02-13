package com.blitzoffline.blitzactions.actions.broadcast

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.msg
import org.bukkit.Bukkit

class MessageBroadcastAction : Action {
    override val name = "BROADCAST"
    override fun run(actionData: ActionData) {
        val players = Bukkit.getOnlinePlayers()
        val target = actionData.target
        val message = actionData.data

        players.forEach { player ->
            if (target != null) message.msg(player, target)
            else message.msg(player)
        }
    }
}