package com.imdamilan.textformatting

import com.imdamilan.textformatting.event.PlayerChatEvent
import org.bstats.bukkit.Metrics
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class TextFormatting : JavaPlugin() {

    override fun onEnable() {
        Metrics(this, 15860)
        logger.info("Text Formatting is enabled!")
        Bukkit.getServer().pluginManager.registerEvents(PlayerChatEvent(), this)
    }

    override fun onDisable() {
        logger.info("Text Formatting is disabled!")
    }
}
