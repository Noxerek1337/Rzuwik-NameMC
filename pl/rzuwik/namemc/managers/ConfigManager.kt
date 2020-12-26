package pl.rzuwik.namemc.managers

import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.inventory.ItemStack

class ConfigManager(plugin: JavaPlugin) {
    var SERVER_IP: String
    var REWARDED: String
    var SUBTITLE: String
    var TITLE: String
    var NOTLIKED: String
    var REWARD: ItemStack

    init {
        plugin.saveDefaultConfig()
        val config = plugin.config
        SERVER_IP = config.getString("config.messages.ip")
        NOTLIKED = config.getString("config.messages.notliked")
        TITLE = config.getString("config.messages.title")
        REWARDED = config.getString("config.messages.rewarded")
        SUBTITLE = config.getString("config.messages.subtitle")
        REWARD = ItemStack(Material.matchMaterial(config.getString("config.item.material")), config.getInt("config.item.amount"))
    }
}