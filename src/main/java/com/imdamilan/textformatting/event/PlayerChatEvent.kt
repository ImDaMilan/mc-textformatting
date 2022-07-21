package com.imdamilan.textformatting.event

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class PlayerChatEvent : Listener {

    @EventHandler
    fun onPlayerChat(event: AsyncPlayerChatEvent) {
        val formattedMessage = ChatColor.translateAlternateColorCodes('$', event.message)
        event.message = formattedMessage
    }
}
