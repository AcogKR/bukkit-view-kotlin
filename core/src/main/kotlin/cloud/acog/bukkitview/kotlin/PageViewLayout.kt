package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.bukkitViewBuilder.PageViewLayoutBuilder
import io.typecraft.bukkit.view.page.PageViewLayout

fun pageViewLayout(title: String, row: Int, c: PageViewLayoutBuilder.() -> Unit) : PageViewLayout =
    PageViewLayoutBuilder.of(title, row).apply(c).asPageViewLayout()

fun pageViewLayout(title: String, row: Int, slotList: List<Int>, c: PageViewLayoutBuilder.() -> Unit) : PageViewLayout =
    pageViewLayout(title, row) {
        c()
        slots = slotList
    }

fun PageViewLayoutBuilder.controlSlot(slot: Int) = ((row - 1) * 9) + slot
