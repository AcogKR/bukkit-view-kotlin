package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.builder.PageViewLayoutBuilder
import io.typecraft.bukkit.view.*
import io.typecraft.bukkit.view.page.PageViewLayout
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import java.util.stream.Collectors
import java.util.stream.IntStream

fun pageViewLayout(title: String, row: Int, c: PageViewLayoutBuilder.() -> Unit = {}): PageViewLayout {
    val slots = IntStream.range(0, (row - 1) * 9).boxed().collect(Collectors.toList())
    return PageViewLayoutBuilder(
        title, row, mutableListOf(), slots, mutableMapOf()
    ).apply(c).toPageViewLayout()
}


fun simplePageView(title: String, row: Int, items: MutableMap<Int, ViewItem>, c: ChestView.() -> Unit = {}) : ChestView {
    return ChestView(title, row, items).apply(c)
}

fun ChestView.openInventory(player: Player) {
    val holder = ViewHolder()
    holder.view = this
    val inv: Inventory = Bukkit.createInventory(holder, this.row * 9, this.title)
    holder.inventory = inv
    this.items.entries.forEach { (key, value) -> inv.setItem(key, value.item) }
    player.openInventory(inv)
}
