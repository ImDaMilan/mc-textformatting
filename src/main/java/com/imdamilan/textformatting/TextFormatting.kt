package com.imdamilan.textformatting

import com.imdamilan.textformatting.event.BookEditEvent
import com.imdamilan.textformatting.event.PlayerChatEvent
import org.bstats.bukkit.Metrics
import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin

class TextFormatting : JavaPlugin() {

    companion object {
        var instance: Plugin? = null
        var configFile: FileConfiguration? = null
    }

    override fun onEnable() {
        initConfig()
        update()
        Metrics(this, 15860)

        instance = this
        logger.info("Text Formatting is enabled!")
        Bukkit.getServer().pluginManager.registerEvents(PlayerChatEvent(), this)
        Bukkit.getServer().pluginManager.registerEvents(BookEditEvent(), this)
    }

    override fun onDisable() {
        logger.info("Text Formatting is disabled!")
    }

    private fun initConfig() {
        this.saveDefaultConfig()
        configFile = this.config
        configFile!!.addDefault("colorcode-prefix", "$")
        configFile!!.addDefault("autoupdate-enabled", true)
        configFile!!.options().copyDefaults(true)
        this.saveConfig()
    }

    private fun update() {
        if (!Update.isLatest(this, 103551)) {
            if (configFile?.getBoolean("autoupdate-enabled") == true) {
                logger.info("An update is available, downloading...")
                Update.updatePlugin(this, 103551)
            } else {
                logger.warning("Text Formatting is outdated! There is a newer version available! Please update to the latest version!")
            }
        }
    }
}
