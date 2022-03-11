package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import io.typecraft.bukkit.view.ViewItem
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewControl
import io.typecraft.bukkit.view.page.PageViewLayout
import java.util.function.Function

class PageVIewLayoutBuilder(
    val title: String,
    val row: Int,
    var contents: MutableList<Function<PageContext, ViewItem>>,
    var slots: List<Int>,
    var controls: MutableMap<Int, Function<PageContext, PageViewControl>>
) {

    companion object {
        fun ofDefault(title: String, row: Int) : PageVIewLayoutBuilder {
            return PageVIewLayoutBuilder(
                title, row, mutableListOf(), (0 until (row - 1) * 9).toList(), mutableMapOf()
            )
        }
    }

    fun asPageViewLayout() = PageViewLayout(title, row, contents, slots, controls)

    fun asFirstChestView() = asPageViewLayout().toView(1)
}