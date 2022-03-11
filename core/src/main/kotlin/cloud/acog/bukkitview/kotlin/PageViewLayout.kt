package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.BukkitViewBuilder.PageVIewLayoutBuilder
import io.typecraft.bukkit.view.page.PageViewLayout

fun pageViewLayout(title: String, row: Int, c: PageVIewLayoutBuilder.() -> Unit) : PageViewLayout =
    PageVIewLayoutBuilder.ofDefault(title, row).apply(c).asPageViewLayout()
