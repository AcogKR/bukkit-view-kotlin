package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.ChestViewBuilder
import io.typecraft.bukkit.view.ChestView
import io.typecraft.bukkit.view.ViewItem

fun chestView(title: String, row: Int, c: ChestViewBuilder.() -> Unit) : ChestView =
    ChestViewBuilder(title, row, mutableMapOf()).apply(c).asChestView()

fun chestView(title: String, row: Int, items: MutableMap<Int, ViewItem>, c: ChestViewBuilder.() -> Unit = {}) : ChestView =
    ChestViewBuilder(title, row, items).apply(c).asChestView()

fun slot(x: Int = 0, y: Int = 0) = y * 9 + x