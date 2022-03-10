package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.BukkitViewBuilder.ViewItemBuilder
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import org.bukkit.inventory.ItemStack

fun viewItem(item: ItemStack, c: ClickEvent.() -> ViewAction) =
    ViewItemBuilder.ofDefault(item, c)