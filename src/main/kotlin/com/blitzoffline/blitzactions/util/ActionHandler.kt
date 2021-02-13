package com.blitzoffline.blitzactions.util

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.actions.broadcast.*
import com.blitzoffline.blitzactions.actions.console.ConsoleCommandAction
import com.blitzoffline.blitzactions.actions.player.*
import org.bukkit.entity.Player
import java.util.logging.Level

class ActionHandler {
    private val actions = LinkedHashMap<String, Action>()
    private val regex =  "\\[(?<action>[^]]*)] (?<value>.*)".toRegex()

    fun registerActions() {
        listOf(
            ActionBarBroadcastAction(),
            JsonBroadcastAction(),
            MessageBroadcastAction(),
            SoundBroadcastAction(),
            TitleBroadcastAction(),
            ConsoleCommandAction(),
            ActionBarAction(),
            ChatAction(),
            CommandAction(),
            JsonAction(),
            MessageAction(),
            SoundAction(),
            TeleportAction(),
            TitleAction()
        ).forEach { action ->
            actions[action.name] = action
        }
    }

    fun execute(player: Player?, target: Player?, input: String) {
        val (actionName, data) = regex.matchEntire(input)?.destructured ?: return

        val actionData = ActionData(data, player, target)
        val action = actions[actionName] ?: run {
            "Wrong action name: $actionName for: $input".log(Level.WARNING)
            return
        }

        action.run(actionData)
    }
}