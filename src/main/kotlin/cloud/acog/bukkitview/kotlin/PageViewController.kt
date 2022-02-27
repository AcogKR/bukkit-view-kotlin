package cloud.acog.bukkitview.kotlin

import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewAction
import io.typecraft.bukkit.view.page.PageViewControl
import org.bukkit.inventory.ItemStack


fun pageViewController(item: ItemStack, c: ClickEvent.() -> PageViewAction = { PageViewAction.NOTHING }): java.util.function.Function<PageContext, PageViewControl> {
    return java.util.function.Function<PageContext, PageViewControl> { ctx ->
        PageViewControl(item) { e -> c(e) }
    }
}


fun pageViewControllerJust(item: ItemStack, c: ClickEvent.() -> Unit) : java.util.function.Function<PageContext, PageViewControl> {
    return pageViewController(item) {
        c(this)
        PageViewAction.NOTHING
    }
}
