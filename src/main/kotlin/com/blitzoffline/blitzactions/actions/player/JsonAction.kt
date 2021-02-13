package com.blitzoffline.blitzactions.actions.player

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.parseJson
import com.blitzoffline.blitzactions.util.parsePAPI

class JsonAction : Action {
    override val name = "JSON"

    override fun run(actionData: ActionData) {
        val player = actionData.player ?: return
        val target = actionData.target
        val message = actionData.data

        if (target != null) message.parsePAPI(target).parseJson().sendMessage(player)
        else message.parsePAPI(player).parseJson().sendMessage(player)
    }
}