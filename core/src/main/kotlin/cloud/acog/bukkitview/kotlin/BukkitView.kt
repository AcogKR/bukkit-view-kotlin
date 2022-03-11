package cloud.acog.bukkitview.kotlin

import io.typecraft.bukkit.view.BukkitView
import io.typecraft.bukkit.view.ChestView
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

fun Player.openView(view: ChestView, plugin: Plugin) {
   BukkitView.openView(view, this, plugin)
}

fun ChestView.openView(player: Player, plugin: Plugin) {
   BukkitView.openView(this, player, plugin)
}