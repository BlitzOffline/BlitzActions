package com.blitzoffline.blitzactions.util

import me.clip.placeholderapi.PlaceholderAPI
import me.mattstudios.mfmsg.bukkit.BukkitMessage
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.OfflinePlayer
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.logging.Level

private val bukkitMessage = BukkitMessage.create()
fun String.parseJson() = bukkitMessage.parse(this)

fun String.color(): String = ChatColor.translateAlternateColorCodes('&', this)

fun String.parsePAPI(player: Player): String = PlaceholderAPI.setPlaceholders(player, this)
fun List<String>.parsePAPI(player: Player): List<String> = PlaceholderAPI.setPlaceholders(player, this)
fun String.parsePAPI(player: OfflinePlayer): String = PlaceholderAPI.setPlaceholders(player, this)
fun List<String>.parsePAPI(player: OfflinePlayer): List<String> = PlaceholderAPI.setPlaceholders(player, this)

fun String.log(level: Level) = Bukkit.getLogger().log(level, this.color())
fun String.msg(player: Player) = player.sendMessage(this.color().parsePAPI(player))
fun String.msg(player: Player, target: Player) = player.sendMessage(this.color().parsePAPI(target))
fun String.msg(sender: CommandSender) = sender.sendMessage(this.color())