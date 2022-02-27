package cloud.acog.bukkitview.kotlin

import cloud.acog.bukkitview.kotlin.builder.PageViewLayoutBuilder
import io.typecraft.bukkit.view.page.PageViewLayout

fun pageViewLayout(title: String, row: Int, c: PageViewLayoutBuilder.() -> Unit = {}): PageViewLayout {
    return PageViewLayoutBuilder(
        title, row, mutableListOf(), mutableListOf(), mutableMapOf()
    ).apply(c).toPageViewLayout()
}


