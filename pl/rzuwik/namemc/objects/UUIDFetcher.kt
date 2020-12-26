package pl.rzuwik.namemc.objects

import com.google.gson.JsonParser
import org.bukkit.entity.Player
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL

class UUIDFetcher(private val player: Player) {
    fun fetch(): String {
        return try {
            val url = URL("https://api.mojang.com/users/profiles/minecraft/" + player.name)
            val reader = BufferedReader(InputStreamReader(url.openConnection().getInputStream()))
            val `object` = JsonParser().parse(reader.readLine()).asJsonObject
            `object`["id"].asString
        } catch (e: IOException) {
            player.uniqueId.toString()
        }
    }

}