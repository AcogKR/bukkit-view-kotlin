package cloud.acog.plugin.utils

import cloud.acog.bukkitview.kotlin.*
import io.typecraft.bukkit.view.ViewAction
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.plugin.Plugin

fun openChestView(player: Player, plugin: Plugin) {
    chestView("title", 1, {

        ViewAction.NOTHING
    }) {

        ViewAction.NOTHING
    }.openView(player, plugin)
}

