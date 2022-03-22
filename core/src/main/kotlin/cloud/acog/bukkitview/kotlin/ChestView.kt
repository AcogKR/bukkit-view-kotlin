package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.ChestViewBuilder
import io.typecraft.bukkit.view.ChestView
import io.typecraft.bukkit.view.CloseEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewItem
import org.bukkit.event.inventory.InventoryType

import java.util.function.Function

fun chestView(title: String, row: Int, c: ChestViewBuilder.() -> Unit) : ChestView =
    ChestViewBuilder.just(title, row).apply(c).asChestView()

fun chestView(title: String, row: Int, c: ChestViewBuilder.() -> Unit, e: CloseEvent.() -> ViewAction) : ChestView =
    ChestViewBuilder(title, row, mutableMapOf(), mutableMapOf(), e).apply(c).asChestView()

fun chestView(title: String, row: Int, items: MutableMap<Int, ViewItem>, c: ChestViewBuilder.() -> Unit = {}, e: CloseEvent.() -> ViewAction = { ViewAction.NOTHING }) : ChestView =
    ChestViewBuilder(title, row, items, mutableMapOf(), e).apply(c).asChestView()

fun chestView(title: String, type: InventoryType) : ChestView = TODO()

fun slot(x: Int = 0, y: Int = 0) = y * 9 + x