package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import io.typecraft.bukkit.view.ChestView
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.CloseEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewItem
import org.bukkit.inventory.ItemStack

import java.util.function.Function

class ChestViewBuilder(
    var title: String,
    private val row: Int,
    var controls: MutableMap<Int, ViewItem>,
    var contents: MutableMap<Int, ItemStack>,
    var onClose: Function<CloseEvent, ViewAction>
) {

    companion object {
        fun just(title: String, row: Int) : ChestViewBuilder {
            return ChestViewBuilder(title, row, mutableMapOf(), mutableMapOf()) { ViewAction.NOTHING }
        }
    }

    fun slotItem(slot: Int, c: ViewItemBuilder.() -> Unit) {
        controls[slot] = ViewItemBuilder().apply(c).asViewItem()
    }

    fun slotItem(slot: Int, item: ItemStack, c: ClickEvent.() -> ViewAction = { ViewAction.NOTHING }) {
        controls[slot] = ViewItemBuilder.ofDefault(item, c).asViewItem()
    }

    fun slotItem(slot: Int, viewItem: ViewItem) {
        controls[slot] = viewItem
    }

    fun slotItem(slot: Int, item: ItemStack) {
        contents[slot] = item
    }

    fun putItem(c: ViewItemBuilder.() -> Unit) {
        controls[contents.size] = ViewItemBuilder().apply(c).asViewItem()
    }

    fun putItem(viewItem: ViewItem) {
        controls[contents.size] = viewItem
    }

    fun asChestView() : ChestView = ChestView(title, row, controls, contents, onClose)
}



