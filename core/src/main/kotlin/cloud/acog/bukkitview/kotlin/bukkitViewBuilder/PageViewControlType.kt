package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import io.typecraft.bukkit.view.page.PageViewAction

enum class PageViewControlType {

    NEXT_ITEM,
    PREVIOUS_ITEM,
    NOTHING,
    REOPEN,
    CLOSE;

    fun format(page: Int = 1) : PageViewAction {
        return when (this) {
            NEXT_ITEM -> PageViewAction.SetPage(page + 1)
            PREVIOUS_ITEM -> PageViewAction.SetPage(page - 1)
            NOTHING -> PageViewAction.NOTHING
            CLOSE -> PageViewAction.CLOSE
            REOPEN -> PageViewAction.REOPEN
        }
    }

}