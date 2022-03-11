package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.ViewItemBuilder
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewItem
import io.typecraft.bukkit.view.page.PageContext
import org.bukkit.inventory.ItemStack
import java.util.function.Function

fun viewItem(item: ItemStack, c: ClickEvent.() -> ViewAction) = ViewItemBuilder.ofDefault(item, c).asViewItem()

fun justViewItem(item: ItemStack) = viewItem(item) { ViewAction.NOTHING }

fun pageViewItem(item: ItemStack, c: ClickEvent.() -> ViewAction) = ViewItemBuilder.ofDefault(item, c).asPageViewItem()

fun justPageViewItem(item: ItemStack) = pageViewItem(item) { ViewAction.NOTHING }

fun pageContextViewItem(item: ItemStack, c: (Pair<PageContext, ClickEvent>) -> ViewAction) : Function<PageContext, ViewItem> = Function { ctx ->
    TODO() // 이거 어째 만들지...?
}