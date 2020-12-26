package pl.rzuwik.namemc.utils

import org.bukkit.entity.Player
import net.minecraft.server.v1_8_R3.IChatBaseComponent
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle
import org.bukkit.ChatColor
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer

object TitleUtil {
    fun sendTitle(player: Player, text: String) {
        val chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\",color:" + ChatColor.GRAY.name.toLowerCase() + "}")
        val title = PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle)
        val length = PacketPlayOutTitle(20, 50, 20)
        (player as CraftPlayer).handle.playerConnection.sendPacket(title)
        player.handle.playerConnection.sendPacket(length)
    }

    fun sendSubTitle(player: Player, text: String) {
        val chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\",color:" + ChatColor.GRAY.name.toLowerCase() + "}")
        val title = PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatTitle)
        val length = PacketPlayOutTitle(20, 50, 20)
        (player as CraftPlayer).handle.playerConnection.sendPacket(title)
        player.handle.playerConnection.sendPacket(length)
    }
}