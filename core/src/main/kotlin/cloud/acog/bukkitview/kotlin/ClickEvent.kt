package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.ViewItemBuilder
import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import java.util.function.Function

fun clickEvent(c: ClickEvent.() -> ViewAction): Function<ClickEvent, ViewAction> = Function<ClickEvent, ViewAction> { c(it) }

fun ViewItemBuilder.clickEvent(c: ClickEvent.() -> ViewAction) : Function<ClickEvent, ViewAction> {
    onClick = cloud.acog.bukkitview.kotlin.clickEvent { c() }
    return onClick
}


