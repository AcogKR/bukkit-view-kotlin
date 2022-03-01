package cloud.acog.bukkitview.kotlin

import io.typecraft.bukkit.view.ClickEvent
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewAction
import io.typecraft.bukkit.view.page.PageViewControl
import org.bukkit.Material
import org.bukkit.inventory.ItemStack


fun pageViewController(item: ItemStack, c: ClickEvent.() -> PageViewAction = { PageViewAction.NOTHING }): java.util.function.Function<PageContext, PageViewControl> {
    return java.util.function.Function<PageContext, PageViewControl> { _ ->
        PageViewControl(item) { e -> c(e) }
    }
}


fun pageViewControllerJust(item: ItemStack, c: ClickEvent.() -> Unit) : java.util.function.Function<PageContext, PageViewControl> {
    return pageViewController(item) {
        c(this)
        PageViewAction.NOTHING
    }
}

fun pageControllerItem(item: ItemStack, type: PageControllerType) : java.util.function.Function<PageContext, PageViewControl> {
    return java.util.function.Function { ctx: PageContext ->
        val page = when (type) {
            PageControllerType.NEXT_ITEM -> ctx.page + 1
            PageControllerType.PREVIOUS_ITEM -> ctx.page - 1
        }
        val itemMeta = item.itemMeta
        val lore = item.itemMeta!!.lore!!.joinToString("\n")
            .replace("{page}", ctx.page.toString())
            .replace("{maxPage}", ctx.maxPage.toString())
        itemMeta!!.lore = lore.split("\n").toList()
        item.itemMeta = itemMeta
        PageViewControl(item) { PageViewAction.SetPage(page) }
    }
}

fun pageSimpleController(material: Material, display: String, loreList: List<String>, type: PageControllerType) : java.util.function.Function<PageContext, PageViewControl> {
    return java.util.function.Function { ctx: PageContext ->
        val stringDisplay = display.replace("{page}", ctx.page.toString()).replace("{maxPage}", ctx.maxPage.toString())
        val stringLore = loreList.joinToString("\n").replace("{page}", ctx.page.toString()).replace("{maxPage}", ctx.maxPage.toString())
        val page = when (type) {
            PageControllerType.NEXT_ITEM -> ctx.page + 1
            PageControllerType.PREVIOUS_ITEM -> ctx.page - 1
        }
        val item = ItemStack(material)
        val meta = item.itemMeta!!.apply {
            setDisplayName(stringDisplay)
            lore = stringLore.split("\n").toList()
        }
        item.itemMeta = meta
        PageViewControl(item) { PageViewAction.SetPage(page)}
    }
}