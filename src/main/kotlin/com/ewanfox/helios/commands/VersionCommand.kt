package com.ewanfox.helios.commands
import com.ewanfox.helios.Version
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.MinecraftServer
import world.cepi.kstom.command.kommand.Kommand

object VersionCommand : Kommand({
                         default {
                             val msg = Component.text("This server is running", NamedTextColor.GRAY).append(Component.text(" Minestom ${MinecraftServer.VERSION_NAME}",NamedTextColor.GREEN).hoverEvent(HoverEvent.showText(Component.text("https://github.com/Minestom/Minestom"))).clickEvent(ClickEvent.openUrl("https://github.com/Minestom/Minestom"))).append(Component.text("\n and Helios v${Version().version}",NamedTextColor.LIGHT_PURPLE));
                         }
},"version") {

}