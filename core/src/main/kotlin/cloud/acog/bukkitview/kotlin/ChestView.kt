package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.BukkitViewBuilder.ChestViewBuilder
import io.typecraft.bukkit.view.ChestView

fun chestView(title: String, row: Int, c: ChestViewBuilder.() -> Unit) : ChestView =
    ChestViewBuilder(title, row * 9, mutableMapOf()).apply(c).asChestView()
