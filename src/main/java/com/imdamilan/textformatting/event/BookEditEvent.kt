package com.imdamilan.textformatting.event

import com.imdamilan.textformatting.TextFormatting
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEditBookEvent

class BookEditEvent : Listener {

    @EventHandler
    fun onBookEdit(event: PlayerEditBookEvent) {
        val meta = event.newBookMeta
        meta.pages = meta.pages.map {
            ChatColor.translateAlternateColorCodes(TextFormatting.configFile!!.getString("colorcode-prefix")!![0], it)
        }
    }
}
