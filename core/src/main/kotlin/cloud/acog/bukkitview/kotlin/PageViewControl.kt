package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.PageViewControlBuilder
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewAction
import io.typecraft.bukkit.view.page.PageViewControl
import org.bukkit.inventory.ItemStack
import java.util.function.Function

fun pageViewControl(item: ItemStack, c: ClickEvent.() -> PageViewAction = { PageViewAction.NOTHING }) : PageViewControl =
    PageViewControlBuilder.of(item, c).asPageViewControl()

fun functionPageViewControl(item: ItemStack, c: ClickEvent.() -> PageViewAction = { PageViewAction.NOTHING }) =
    Function<PageContext, PageViewControl> { pageViewControl(item, c)}

fun simplePageViewControl(item: ItemStack, type: PageViewControlType) =
    Function<PageContext, PageViewControl> { ctx -> pageViewControl(item) { type.format(ctx.page) }}