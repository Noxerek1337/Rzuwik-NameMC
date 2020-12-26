package pl.rzuwik.namemc.commands

import org.bukkit.command.Command
import pl.rzuwik.namemc.Main.Companion.rewardManager
import pl.rzuwik.namemc.Main.Companion.configManager
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import pl.rzuwik.namemc.objects.UUIDFetcher
import pl.rzuwik.namemc.utils.TitleUtil
import java.io.IOException
import java.net.URL
import java.util.*

class RewardCommand(plugin: JavaPlugin) : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, s: String, args: Array<String>): Boolean {
        val player = sender as Player
        if (rewardManager!!.getPlayers().contains(player.name)) {
            player.sendMessage(configManager!!.REWARDED)
            return false
        }
        val fetcher = UUIDFetcher(player)
        try {
            val scanner = Scanner(URL("https://api.namemc.com/server/" + configManager!!.SERVER_IP + "/likes?profile=" + fetcher.fetch()).openStream())
            val status = java.lang.Boolean.parseBoolean(scanner.next())
            if (status) {
                TitleUtil.sendTitle(player, configManager!!.TITLE)
                TitleUtil.sendSubTitle(player, configManager!!.SUBTITLE)
                player.inventory.addItem(configManager!!.REWARD)
                rewardManager!!.addPlayer(player.name)
            } else {
                player.sendMessage(configManager!!.NOTLIKED)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return true
    }

    init {
        plugin.getCommand("nagroda").executor = this
    }
}