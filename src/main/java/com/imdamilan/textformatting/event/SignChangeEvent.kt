package com.imdamilan.textformatting.event

import com.imdamilan.textformatting.TextFormatting
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.SignChangeEvent

class SignChangeEvent : Listener {

    @EventHandler
    fun onSignChanged(event: SignChangeEvent) {
        val lines: Array<String> = event.lines
        for (n in 0..3) event.setLine(n,
            ChatColor.translateAlternateColorCodes(TextFormatting.configFile.getString("colorcode-prefix")!![0], lines[n]))
    }
}
