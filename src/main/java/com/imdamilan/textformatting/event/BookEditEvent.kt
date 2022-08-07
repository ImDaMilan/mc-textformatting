package com.imdamilan.textformatting.event

import com.imdamilan.textformatting.TextFormatting
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEditBookEvent
import org.bukkit.inventory.meta.BookMeta

class BookEditEvent : Listener {

    @EventHandler
    fun onBookEdit(event: PlayerEditBookEvent) {
        if (event.player.hasPermission("textformatting.book"))
            event.newBookMeta = format(event.newBookMeta)
    }

    private fun format(meta: BookMeta): BookMeta {
        val pages = meta.pages
        val new: MutableList<String> = ArrayList()
        for (page in pages)
            new.add(ChatColor.translateAlternateColorCodes(TextFormatting.configFile.getString("colorcode-prefix")!![0], page))
        meta.pages = new
        return meta
    }
}
