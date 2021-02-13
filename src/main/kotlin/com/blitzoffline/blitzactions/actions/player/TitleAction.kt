package com.blitzoffline.blitzactions.actions.player

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.color
import com.blitzoffline.blitzactions.util.parsePAPI

class TitleAction : Action {
    override val name = "TITLE"

    override fun run(actionData: ActionData) {
        val player = actionData.player ?: return
        val target = actionData.target
        val arguments = if (target != null) actionData.data.parsePAPI(target).split(";") else actionData.data.parsePAPI(player).split(";")

        val title = arguments[0].color()
        val subtitle = arguments[1].color()

        player.sendTitle(title, subtitle, 10, 70, 20)
    }
}