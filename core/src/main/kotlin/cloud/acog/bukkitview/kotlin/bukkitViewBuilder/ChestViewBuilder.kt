package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import cloud.acog.bukkitview.kotlin.simpleItem
import cloud.acog.bukkitview.kotlin.toItem
import cloud.acog.bukkitview.kotlin.viewControl
import io.typecraft.bukkit.view.*
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import java.util.function.Function

class ChestViewBuilder(
    var title: String,
    val row: Int,
    var controls: MutableMap<Int, ViewControl>,
    var contents: MutableMap<Int, ItemStack>,
    var onClose: Function<CloseEvent, ViewAction>
) {

    companion object {
        fun of(title: String, row: Int): ChestViewBuilder {
            return ChestViewBuilder(title, row, mutableMapOf(), mutableMapOf()) { ViewAction.NOTHING }
        }
    }

    fun asChestView(): ChestView = ChestView.of(
        title, row, ViewContents.of(controls, contents), onClose
    )

    /**
     * ViewControl
     */
    fun controlItem(slot: Int, item: ItemStack, c: ClickEvent.() -> ViewAction) {
        controls[slot] = viewControl(item, c)
    }

    fun controlItem(slot: Int, c: ViewControlBuilder.() -> Unit) {
        controls[slot] = ViewControlBuilder().apply(c).asViewControl()
    }

    fun controlItem(slot: Int, viewControl: ViewControl) {
        controls[slot] = viewControl
    }

    fun controlItem(
        slot: Int,
        material: Material,
        display: String,
        lore: List<String>,
        c: ClickEvent.() -> ViewAction = { ViewAction.NOTHING }
    ) {
        controls[slot] = viewControl(simpleItem(material, display, lore), c)
    }

    /**
     * ItemStack
     */
    fun itemSlot(slot: Int, item: ItemStack) {
        contents[slot] = item
    }

    fun itemSlot(slot: Int, material: Material, c: ItemMeta.() -> Unit = {}) {
        contents[slot] = material.toItem(1).apply {
            itemMeta = itemMeta?.apply(c)
        }
    }
}



