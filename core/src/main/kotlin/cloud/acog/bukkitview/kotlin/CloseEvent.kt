package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.ChestViewBuilder
import io.typecraft.bukkit.view.CloseEvent
import io.typecraft.bukkit.view.ViewAction

import java.util.function.Function

fun closeEvent(c: CloseEvent.() -> ViewAction): Function<CloseEvent, ViewAction> = Function<CloseEvent, ViewAction> { c(it) }

fun ChestViewBuilder.closeEvent(c: CloseEvent.() -> ViewAction) : Function<CloseEvent, ViewAction> {
    onClose = cloud.acog.bukkitview.kotlin.closeEvent { c() }
    return onClose
}