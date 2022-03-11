package cloud.acog.bukkitview.kotlin.BukkitViewBuilder

import io.typecraft.bukkit.view.ChestView
import io.typecraft.bukkit.view.ViewItem

class ChestViewBuilder(var title: String, private val row: Int, var items: MutableMap<Int, ViewItem>) {

    fun slot(slot: Int, c: ViewItemBuilder.() -> Unit) {
        items[slot] = ViewItemBuilder().apply(c).asViewItem()
    }

    fun asChestView() : ChestView = ChestView(title, row, items)
}



