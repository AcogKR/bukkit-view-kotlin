package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.ViewControlBuilder
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewControl
import org.bukkit.inventory.ItemStack

fun viewControl(item: ItemStack, c: ClickEvent.() -> ViewAction = { ViewAction.NOTHING }) : ViewControl {
    return ViewControlBuilder.of(item, c).asViewControl()
}