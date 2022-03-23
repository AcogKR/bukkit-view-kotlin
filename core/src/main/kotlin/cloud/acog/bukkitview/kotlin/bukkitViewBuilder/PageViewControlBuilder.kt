package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import cloud.acog.bukkitview.kotlin.pageControlClickEvent
import cloud.acog.bukkitview.kotlin.simpleItem
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewAction
import io.typecraft.bukkit.view.page.PageViewControl
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import java.util.function.Function

class PageViewControlBuilder {

    var item: ItemStack = simpleItem(Material.AIR)
    var onClick: Function<ClickEvent, PageViewAction> = pageControlClickEvent()

    companion object {
        fun of(itemStack: ItemStack, onClickEvent: Function<ClickEvent, PageViewAction>) : PageViewControlBuilder {
            return PageViewControlBuilder().apply {
                item = itemStack
                onClick = onClickEvent
            }
        }
    }

    fun justPageViewControl(): PageViewControl = PageViewControl.of(item, onClick)

    fun asPageViewControl() : Function<PageContext, PageViewControl> = Function { justPageViewControl() }

}