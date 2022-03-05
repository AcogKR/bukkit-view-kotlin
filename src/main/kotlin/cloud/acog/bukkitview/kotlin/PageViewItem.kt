package cloud.acog.bukkitview.kotlin

import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewItem
import io.typecraft.bukkit.view.page.PageContext
import org.bukkit.inventory.ItemStack

fun pageViewItem(item: ItemStack, c: ClickEvent.() -> ViewAction = { ViewAction.NOTHING }): java.util.function.Function<PageContext, ViewItem> {
    return java.util.function.Function<PageContext, ViewItem> { _ ->
        ViewItem(item) { e -> c(e) }
    }
}

fun pageViewItemJust(item: ItemStack, c: ClickEvent.() -> Unit = { }): java.util.function.Function<PageContext, ViewItem> {
    return pageViewItem(item) {
        c(this)
        ViewAction.NOTHING
    }
}

fun simpleViewItem(item: ItemStack) : ViewItem {
    return ViewItem(item) { _ -> ViewAction.NOTHING }
}
