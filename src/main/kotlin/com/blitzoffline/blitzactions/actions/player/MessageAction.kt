package com.blitzoffline.blitzactions.actions.player

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.msg

class MessageAction : Action {
    override val name: String = "MESSAGE"

    override fun run(actionData: ActionData) {
        val player = actionData.player ?: return
        val target = actionData.target
        val message = actionData.data

        if (target != null) message.msg(player, target)
        else message.msg(player)
    }
}