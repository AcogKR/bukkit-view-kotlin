package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.ViewControlBuilder
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewControl
import io.typecraft.bukkit.view.page.PageContext
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import java.util.function.Function

fun viewControl(item: ItemStack, c: ClickEvent.() -> ViewAction = { ViewAction.NOTHING }) : ViewControl =
    ViewControlBuilder.of(item, c).asViewControl()

fun functionViewControl(item: ItemStack, c: ClickEvent.() -> ViewAction = { ViewAction.NOTHING }) =
    Function<PageContext, ViewControl> { viewControl(item, c) }

fun viewControl(c: ViewControlBuilder.() -> Unit) : ViewControl =
    ViewControlBuilder.of(simpleItem(Material.AIR), controlClickEvent()).apply(c).asViewControl()

fun functionViewControl(c: ViewControlBuilder.() -> Unit) {
    Function<PageContext, ViewControl> { viewControl { c() } }
}