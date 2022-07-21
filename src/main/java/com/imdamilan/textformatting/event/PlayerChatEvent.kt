package com.imdamilan.textformatting.event

import com.imdamilan.textformatting.TextFormatting
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class PlayerChatEvent : Listener {

    @EventHandler
    fun onPlayerChat(event: AsyncPlayerChatEvent) {
        val formattedMessage = ChatColor.translateAlternateColorCodes(
            TextFormatting.configFile!!.getString("colorcode-prefix")!![0], event.message)
        event.message = formattedMessage
    }
}
