package pl.rzuwik.namemc.managers

import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.IOException
import java.util.ArrayList

class RewardManager(plugin: JavaPlugin) {
    private val dataFolder: File
    private val players: MutableList<String> = ArrayList()
    fun getPlayers(): List<String> {
        return players
    }

    fun addPlayer(name: String) {
        players.add(name)
        try {
            File(dataFolder, name).createNewFile()
        } catch (ignored: IOException) {
        }
    }

    init {
        dataFolder = plugin.dataFolder
        val files = dataFolder.listFiles()
        if (files != null) {
            for (file in files) {
                players.add(file.name)
            }
        }
    }
}