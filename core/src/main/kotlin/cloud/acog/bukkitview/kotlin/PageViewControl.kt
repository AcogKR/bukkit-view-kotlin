package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.PageViewControlBuilder
import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.PageViewControlType
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewAction
import io.typecraft.bukkit.view.page.PageViewControl
import org.bukkit.inventory.ItemStack
import java.util.function.Function

fun viewControl(item: ItemStack, c: ClickEvent.() -> PageViewAction) = PageViewControlBuilder.ofDefault(item, c).asViewControl()

fun justViewControl(item: ItemStack) = viewControl(item) { PageViewAction.NOTHING }

fun pageViewControl(item: ItemStack, c: ClickEvent.() -> PageViewAction) = PageViewControlBuilder.ofDefault(item, c).asPageViewControl()

fun justPageViewControl(item: ItemStack) = pageViewControl(item) { PageViewAction.NOTHING }

fun simpleViewControl(item: ItemStack, type: PageViewControlType): Function<PageContext, PageViewControl> =
    java.util.function.Function<PageContext, PageViewControl> { ctx -> viewControl(item) { type.format(ctx.page) } }

//fun pageContextViewControl(item: ItemStack, c: Pair<PageContext, ClickEvent>.() -> PageViewAction) : Function<PageContext, PageViewControl> {
//    val value = Function { ctx -> viewControl(item) { c(this) } }
//}