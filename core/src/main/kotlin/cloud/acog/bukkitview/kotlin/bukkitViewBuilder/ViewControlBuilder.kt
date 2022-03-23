package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import cloud.acog.bukkitview.kotlin.controlClickEvent
import cloud.acog.bukkitview.kotlin.simpleItem
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewControl
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

import java.util.function.Function

class ViewControlBuilder {

    var item: ItemStack = simpleItem(Material.AIR)
    var onClick: Function<ClickEvent, ViewAction> = controlClickEvent()

    companion object {
        fun of(itemStack: ItemStack, onClickEvent: Function<ClickEvent, ViewAction>) : ViewControlBuilder =
            ViewControlBuilder().apply {
                item = itemStack
                onClick = onClickEvent
            }
    }

    fun asViewControl(): ViewControl = ViewControl.of(item, onClick)
}
