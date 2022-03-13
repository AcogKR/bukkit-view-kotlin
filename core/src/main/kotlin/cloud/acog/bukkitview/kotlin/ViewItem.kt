package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.ViewItemBuilder
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import org.bukkit.inventory.ItemStack

fun viewItem(item: ItemStack, c: ClickEvent.() -> ViewAction) = ViewItemBuilder.ofDefault(item, c).asViewItem()

fun justViewItem(item: ItemStack) = viewItem(item) { ViewAction.NOTHING }

fun pageViewItem(item: ItemStack, c: ClickEvent.() -> ViewAction) = ViewItemBuilder.ofDefault(item, c).asPageViewItem()

fun justPageViewItem(item: ItemStack) = pageViewItem(item) { ViewAction.NOTHING }
