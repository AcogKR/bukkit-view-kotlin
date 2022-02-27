package cloud.acog.bukkitview.kotlin.builder

import io.typecraft.bukkit.view.ViewItem
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewControl
import io.typecraft.bukkit.view.page.PageViewLayout

import java.util.function.Function

class PageViewLayoutBuilder(
    var title: String,
    var row: Int,
    var contents: List<Function<PageContext, ViewItem>>,
    var slots: List<Int>,
    var controls: Map<Int, Function<PageContext, PageViewControl>>
) {
    fun toPageViewLayout() : PageViewLayout {
        return PageViewLayout(title, row, contents, slots, controls)
    }
}