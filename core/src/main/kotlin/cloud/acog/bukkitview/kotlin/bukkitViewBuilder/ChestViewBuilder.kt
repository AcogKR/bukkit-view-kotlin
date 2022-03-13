package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import io.typecraft.bukkit.view.ChestView
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewItem
import org.bukkit.inventory.ItemStack

class ChestViewBuilder(var title: String, private val row: Int, var items: MutableMap<Int, ViewItem>) {

    fun slotItem(slot: Int, c: ViewItemBuilder.() -> Unit) {
        items[slot] = ViewItemBuilder().apply(c).asViewItem()
    }

    fun slotItem(slot: Int, item: ItemStack, c: ClickEvent.() -> ViewAction) {
        items[slot] = ViewItemBuilder.ofDefault(item, c).asViewItem()
    }

    fun slotItem(slot: Int, viewItem: ViewItem) {
        items[slot] = viewItem
    }

    fun putItem(c: ViewItemBuilder.() -> Unit) {
        items[items.size] = ViewItemBuilder().apply(c).asViewItem()
    }

    fun putItem(viewItem: ViewItem) {
        items[items.size] = viewItem
    }

    fun asChestView() : ChestView = ChestView(title, row, items)
}



