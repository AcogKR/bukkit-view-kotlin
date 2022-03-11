package cloud.acog.bukkitview.kotlin

import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.ViewAction
import java.util.function.Function

fun clickEvent(c: ClickEvent.() -> ViewAction): Function<ClickEvent, ViewAction> =
    Function<ClickEvent, ViewAction> { c(it) }


