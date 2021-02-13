package com.blitzoffline.blitzactions.actions

interface Action {
    val name: String
    fun run(actionData: ActionData) {}
}