package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.PageVIewLayoutBuilder
import io.typecraft.bukkit.view.page.PageViewLayout

fun pageViewLayout(title: String, row: Int, c: PageVIewLayoutBuilder.() -> Unit) : PageViewLayout =
    PageVIewLayoutBuilder.of(title, row).apply(c).asPageViewLayout()

fun pageViewLayout(title: String, row: Int, slots: List<Int>, c: PageVIewLayoutBuilder.() -> Unit) : PageViewLayout =
    PageVIewLayoutBuilder.of(title, row).apply {
        c(this)
        this.slots = slots
    }.asPageViewLayout()

fun PageVIewLayoutBuilder.controlSlot(slot: Int) = ((row - 1) * 9) + slot