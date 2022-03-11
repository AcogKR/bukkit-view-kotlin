package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import io.typecraft.bukkit.view.ChestView
import io.typecraft.bukkit.view.ViewItem

class ChestViewBuilder(var title: String, private val row: Int, var items: MutableMap<Int, ViewItem>) {

    fun slot(slot: Int, c: ViewItemBuilder.() -> Unit) {
        items[slot] = ViewItemBuilder().apply(c).asViewItem()
    }

    fun slot(slot: Int, viewItem: ViewItem) {
        items[slot] = viewItem
    }

    fun put(c: ViewItemBuilder.() -> Unit) {
        items[items.size] = ViewItemBuilder().apply(c).asViewItem()
    }

    fun put(viewItem: ViewItem) {
        items[items.size] = viewItem
    }

    fun asChestView() : ChestView = ChestView(title, row, items)
}



