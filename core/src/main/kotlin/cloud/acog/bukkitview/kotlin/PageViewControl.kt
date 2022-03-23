package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.PageViewControlBuilder
import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.PageViewControlType
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewAction
import io.typecraft.bukkit.view.page.PageViewControl
import org.bukkit.inventory.ItemStack
import java.util.function.Function


fun justPageViewControl(item: ItemStack, c: ClickEvent.() -> PageViewAction = { PageViewAction.NOTHING}) : PageViewControl {
    return PageViewControlBuilder.of(item, c).justPageViewControl()
}

fun pageViewControl(item: ItemStack, c: ClickEvent.() -> PageViewAction = { PageViewAction.NOTHING}) : Function<PageContext, PageViewControl> {
    return PageViewControlBuilder.of(item, c).asPageViewControl()
}

fun simpleViewControl(item: ItemStack, type: PageViewControlType) : Function<PageContext, PageViewControl> {
    return Function<PageContext, PageViewControl> { ctx -> justPageViewControl(item) { type.format(ctx.page) } }
}
