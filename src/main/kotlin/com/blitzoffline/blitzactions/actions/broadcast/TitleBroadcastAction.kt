package com.blitzoffline.blitzactions.actions.broadcast

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.color
import com.blitzoffline.blitzactions.util.parsePAPI
import org.bukkit.Bukkit

class TitleBroadcastAction : Action {
    override val name = "TITLEBROADCAST"

    override fun run(actionData: ActionData) {
        val players = Bukkit.getOnlinePlayers()
        val target = actionData.target
        val arguments = actionData.data.split(";")

        val title = arguments[0].color()
        val subtitle = arguments[1].color()

        players.forEach { player ->
            if (target != null) player.sendTitle(title.parsePAPI(target), subtitle.parsePAPI(target), 10 ,70, 20)
            else player.sendTitle(title.parsePAPI(player), subtitle.parsePAPI(player), 10 ,70, 20)
        }
    }
}