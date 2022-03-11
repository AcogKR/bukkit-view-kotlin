package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewAction
import io.typecraft.bukkit.view.page.PageViewControl
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import java.util.function.Function

class PageViewControlBuilder {

    var item: ItemStack = ItemStack(Material.AIR)
    var onClick: Function<ClickEvent, PageViewAction> = Function { PageViewAction.NOTHING }

    companion object {
        fun ofDefault(itemStack: ItemStack, onClickEvent: Function<ClickEvent, PageViewAction>) : PageViewControlBuilder {
            return PageViewControlBuilder().apply {
                item = itemStack
                onClick = onClickEvent
            }
        }
    }

    fun asViewControl() = PageViewControl(item, onClick)

    fun asPageViewControl() : Function<PageContext, PageViewControl> = Function { asViewControl() }

}