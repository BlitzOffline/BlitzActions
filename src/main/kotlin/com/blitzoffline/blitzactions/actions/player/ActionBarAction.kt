package com.blitzoffline.blitzactions.actions.player

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.parsePAPI

class ActionBarAction : Action {
    override val name = "ACTIONBAR"

    override fun run(actionData: ActionData) {
        val player = actionData.player ?: return
        val target = actionData.target
        val message = if (target != null) actionData.data.parsePAPI(target) else actionData.data.parsePAPI(player)

        player.sendActionBar(message)
    }
}