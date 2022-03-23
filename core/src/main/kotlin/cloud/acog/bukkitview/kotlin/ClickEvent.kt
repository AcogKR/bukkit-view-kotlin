package cloud.acog.bukkitview.kotlin

import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.page.PageViewAction
import java.util.function.Function

fun controlClickEvent(c: ClickEvent.() -> ViewAction = { ViewAction.NOTHING }): Function<ClickEvent, ViewAction> =
    Function<ClickEvent, ViewAction> { c(it) }

fun pageControlClickEvent(c: ClickEvent.() -> PageViewAction = { PageViewAction.NOTHING }) : Function<ClickEvent, PageViewAction> =
    Function<ClickEvent, PageViewAction> { c(it) }