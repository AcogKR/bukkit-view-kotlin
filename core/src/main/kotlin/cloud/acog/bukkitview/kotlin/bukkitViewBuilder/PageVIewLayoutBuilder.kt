package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import cloud.acog.bukkitview.kotlin.item
import cloud.acog.bukkitview.kotlin.simpleItem
import cloud.acog.bukkitview.kotlin.simpleViewControl
import io.typecraft.bukkit.view.ViewItem
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewControl
import io.typecraft.bukkit.view.page.PageViewLayout
import org.bukkit.Material
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

    fun asPageViewLayout() : PageViewLayout =
        if (controls.isEmpty()) PageViewLayout(title, row, contents, slots, ofDefaultControls())
        else PageViewLayout(title, row, contents, slots, controls)

    fun asFirstChestView() = asPageViewLayout().toView(1)

    fun ofDefaultControls() : MutableMap<Int, Function<PageContext, PageViewControl>> {
        val controls = mutableMapOf<Int, Function<PageContext, PageViewControl>>()
        controls[controlSlot(3)] = simpleViewControl(
            simpleItem(Material.STONE_BUTTON, "이전 페이지", emptyList()), PageViewControlType.PREVIOUS_ITEM
        )
        controls[controlSlot(5)] = simpleViewControl(
            simpleItem(Material.STONE_BUTTON, "다음 페이지", emptyList()), PageViewControlType.NEXT_ITEM
        )
        return controls
    }

    private fun controlSlot(slot: Int) = ((row - 1) * 9) + slot
}