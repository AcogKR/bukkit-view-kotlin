package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.PageViewControlBuilder
import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.ViewControlBuilder
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.page.PageViewAction
import java.util.function.Function

fun controlClickEvent(c: ClickEvent.() -> ViewAction = { ViewAction.NOTHING }): Function<ClickEvent, ViewAction> =
    Function<ClickEvent, ViewAction> { c(it) }

fun pageControlClickEvent(c: ClickEvent.() -> PageViewAction = { PageViewAction.NOTHING }) : Function<ClickEvent, PageViewAction> =
    Function<ClickEvent, PageViewAction> { c(it) }

fun ViewControlBuilder.clickEvent(c: ClickEvent.() -> ViewAction) : Function<ClickEvent, ViewAction> {
    onClick = controlClickEvent(c)
    return onClick
}

fun PageViewControlBuilder.clickEvent(c: ClickEvent.() -> PageViewAction) : Function<ClickEvent, PageViewAction> {
    onClick = pageControlClickEvent(c)
    return onClick
}