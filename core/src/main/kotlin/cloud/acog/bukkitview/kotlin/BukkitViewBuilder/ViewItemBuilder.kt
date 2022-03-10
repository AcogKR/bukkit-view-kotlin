package cloud.acog.bukkitview.kotlin.BukkitViewBuilder

import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewItem
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import java.util.function.Function

class ViewItemBuilder {

    var item: ItemStack = ItemStack(Material.AIR)
    var onClick: Function<ClickEvent, ViewAction> = Function { ViewAction.NOTHING }

    companion object {
        fun ofDefault(itemStack: ItemStack, onClicks: Function<ClickEvent, ViewAction>) : ViewItemBuilder{
            return ViewItemBuilder().apply {
                item = itemStack
                onClick = onClicks
            }
        }
    }

    fun asViewItem(): ViewItem {
        return ViewItem(item, onClick)
    }
}