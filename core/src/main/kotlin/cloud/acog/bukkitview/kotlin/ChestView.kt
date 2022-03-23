package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.ChestViewBuilder
import io.typecraft.bukkit.view.ChestView
import io.typecraft.bukkit.view.CloseEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewControl

fun chestView(title: String, row: Int, c: ChestViewBuilder.() -> Unit) =
    ChestViewBuilder.of(title, row).apply(c).asChestView()

fun chestView(title: String, row: Int, c: ChestViewBuilder.() -> Unit, e: CloseEvent.() -> ViewAction) =
    ChestViewBuilder.of(title, row).apply {
        c()
        closeEvent(e)
    }.asChestView()

fun chestView(title: String, row: Int, controls: MutableMap<Int, ViewControl>, c: ChestViewBuilder.() -> Unit) : ChestView =
    ChestViewBuilder(title, row, controls, mutableMapOf()) { ViewAction.NOTHING }.apply(c).asChestView()

fun slot(x: Int = 0, y: Int = 0) = y * 9 + x