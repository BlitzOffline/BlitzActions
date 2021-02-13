package com.blitzoffline.blitzactions.actions.console

import com.blitzoffline.blitzactions.actions.Action
import com.blitzoffline.blitzactions.actions.ActionData
import com.blitzoffline.blitzactions.util.parsePAPI
import org.bukkit.Bukkit

class ConsoleCommandAction : Action {
    override val name = "CONSOLECOMMAND"

    override fun run(actionData: ActionData) {
        val target = actionData.target
        val command = actionData.data

        if (target != null) Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.parsePAPI(target))
        else Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command)
    }
}