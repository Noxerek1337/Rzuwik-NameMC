package pl.rzuwik.namemc

import org.bukkit.plugin.java.JavaPlugin
import pl.rzuwik.namemc.managers.ConfigManager
import pl.rzuwik.namemc.managers.RewardManager
import pl.rzuwik.namemc.commands.RewardCommand

class Main : JavaPlugin() {
    override fun onEnable() {
        configManager = ConfigManager(this)
        rewardManager = RewardManager(this)
        RewardCommand(this)
    }

    companion object {
        @JvmStatic
        var configManager: ConfigManager? = null
            private set
        @JvmStatic
        var rewardManager: RewardManager? = null
            private set

    }
}