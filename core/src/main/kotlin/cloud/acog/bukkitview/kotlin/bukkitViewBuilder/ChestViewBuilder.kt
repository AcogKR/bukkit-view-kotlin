package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import io.typecraft.bukkit.view.ChestView
import io.typecraft.bukkit.view.ViewItem

class ChestViewBuilder(var title: String, private val row: Int, var items: MutableMap<Int, ViewItem>) {

    fun slotItem(slot: Int, c: ViewItemBuilder.() -> Unit) {
        items[slot] = ViewItemBuilder().apply(c).asViewItem()
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

    private fun slot(x: Int = 0, y: Int = 1) = (x * y)
}



