package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import cloud.acog.bukkitview.kotlin.*
import io.typecraft.bukkit.view.ViewControl
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewControl
import io.typecraft.bukkit.view.page.PageViewLayout
import org.bukkit.Material
import java.util.function.Function

class PageViewLayoutBuilder(
    private val title: String,
    val row: Int,
    var elements: MutableList<Function<PageContext, ViewControl>>,
    var slots: List<Int>,
    var controls: MutableMap<Int, Function<PageContext, PageViewControl>>
) {

    companion object {
        fun of(title: String, row: Int) : PageViewLayoutBuilder {
            return PageViewLayoutBuilder(
                title, row, mutableListOf(), (0 until (row - 1) * 9).toList(), mutableMapOf()
            )
        }
    }

    fun asPageViewLayout() : PageViewLayout {
        return if (controls.isEmpty())  {
            PageViewLayout.of(title, row, elements, slots, ofDefaultControls())
        } else {
            PageViewLayout.of(title, row, elements, slots, controls)
        }
    }

    private fun ofDefaultControls() : MutableMap<Int, Function<PageContext, PageViewControl>> {
        controls[controlSlot(3)] = simplePageViewControl(
            simpleItem(Material.STONE_BUTTON, "이전 페이지"),
            PageViewControlType.PREVIOUS_ITEM
        )
        controls[controlSlot(5)] = simplePageViewControl(
            simpleItem(Material.STONE_BUTTON, "다음 페이지"),
            PageViewControlType.NEXT_ITEM
        )
        return controls
    }
}