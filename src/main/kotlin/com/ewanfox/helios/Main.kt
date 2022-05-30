package com.ewanfox.helios

import com.ewanfox.helios.commands.VersionCommand
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.MinecraftServer
import net.minestom.server.event.EventListener
import net.minestom.server.event.EventNode
import net.minestom.server.event.player.PlayerChatEvent
import net.minestom.server.event.player.PlayerSpawnEvent
import net.minestom.server.extensions.Extension
class Main : Extension() {
    override fun initialize(): LoadStatus {
        logger.info("[Helios v${Version().version}] has been enabled");
        val node = eventNode;
        node.addListener(
            EventListener.builder(PlayerChatEvent::class.java)
            .handler { event ->
                run {
                    event.player.sendMessage(
                        Component.text(
                            "Welcome to the game",
                            NamedTextColor.GREEN
                        )
                    );
                    logger.info("Spawn Event");
                }
            }
            .build())
        MinecraftServer.getCommandManager().register(VersionCommand.command)
        return LoadStatus.SUCCESS
    }

    override fun terminate() {
        logger.info("[Helios] has been disabled");
    }

}