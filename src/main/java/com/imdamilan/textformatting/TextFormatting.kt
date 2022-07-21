package com.imdamilan.textformatting

import com.imdamilan.textformatting.event.PlayerChatEvent
import org.bstats.bukkit.Metrics
import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin

class TextFormatting : JavaPlugin() {

    private var configFile: FileConfiguration? = null

    override fun onEnable() {
        initConfig()
        Metrics(this, 15860)
        logger.info("Text Formatting is enabled!")
        Bukkit.getServer().pluginManager.registerEvents(PlayerChatEvent(), this)
    }

    override fun onDisable() {
        logger.info("Text Formatting is disabled!")
    }

    private fun initConfig() {
        this.saveDefaultConfig()
        this.configFile = this.config
        configFile!!.addDefault("autoupdate-enabled", true)
        configFile!!.options().copyDefaults(true)
        this.saveConfig()
    }
}
