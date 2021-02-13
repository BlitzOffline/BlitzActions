package com.blitzoffline.blitzactions.actions.player

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.parsePAPI

class CommandAction : Action {
    override val name = "COMMAND"

    override fun run(actionData: ActionData) {
        val player = actionData.player ?: return
        val target = actionData.target
        val command = actionData.data

        if (target != null) player.performCommand(command.parsePAPI(target))
        else player.performCommand(command.parsePAPI(player))
    }
}