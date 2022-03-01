package cloud.acog.bukkitview.kotlin

import io.typecraft.bukkit.view.page.PageViewAction

enum class PageControllerType {
    NEXT_ITEM,
    PREVIOUS_ITEM,
    NOTHING,
    CLOSE;

    fun format(page: Int = 0) : PageViewAction {
        return when (this) {
            NEXT_ITEM -> PageViewAction.SetPage(page + 1)
            PREVIOUS_ITEM -> PageViewAction.SetPage(page - 1)
            NOTHING -> PageViewAction.NOTHING
            CLOSE -> PageViewAction.CLOSE
        }
    }
}