package com.blitzoffline.blitzactions.actions.player

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.parsePAPI

class ChatAction : Action {
    override val name = "CHAT"

    override fun run(actionData: ActionData) {
        val player = actionData.player ?: return
        val target = actionData.target
        val message = actionData.data

        if (target != null) player.chat(message.parsePAPI(target))
        else player.chat(message.parsePAPI(player))
    }
}